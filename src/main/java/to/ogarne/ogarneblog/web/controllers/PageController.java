package to.ogarne.ogarneblog.web.controllers;

import com.github.slugify.Slugify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import to.ogarne.ogarneblog.model.Page;
import to.ogarne.ogarneblog.service.PageService;
import to.ogarne.ogarneblog.web.CategoryWrapper;
import to.ogarne.ogarneblog.web.ContentUtils;
import to.ogarne.ogarneblog.web.FlashMessage;
import to.ogarne.ogarneblog.web.MarkdownParser;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class
PageController extends RootController{

    @Autowired
    PageService pageService;

    @Autowired
    MarkdownParser markdownParser;

    @Autowired
    ContentUtils contentUtils;

    @Autowired
    Slugify slugify;



    // List of pages
    @RequestMapping("/admin/pages")
    public String getAdminPanel (Model model){
        List<Page> pages = pageService.findAll();
        model.addAttribute("pages", pages);
        return "admin/pages";
    }



    // Get the result of editing the list of pages
    @RequestMapping(value = "/admin/pages", method = RequestMethod.POST)
    public String processListOfPages(@Valid @ModelAttribute CategoryWrapper wrapper, Model model) {
//        pageService.saveInBulk(wrapper.getCategories());
        return "redirect:/admin/pages";
    }



    // Displays content of given page
    @RequestMapping("/pages/{slug}")
    public String getPage(@PathVariable String slug, Model model) {
        Page page = pageService.findBySlug(slug);
        markdownParser.cutHiddenChars(page);
        String description = markdownParser.getPlainText(page, 300);
        model.addAttribute("description", description);
        markdownParser.parse(page);
        model.addAttribute("page", page);

        //Stream menuItems from RootController and locate the item currenty tied to page variable
        //and set it active

        model.addAttribute("menuItems",
                getMenu().stream().map(item -> {
                    item.setActive((item.getSlug().equals(slug)));
                    return item;
                }).collect(Collectors.toList()));


        List<String> imagePaths = contentUtils.getImagePaths(page);
        if (imagePaths.size() > 0) {
            page.setImagePaths(imagePaths);
        }

        return "page";
    }


    // Display form for creating new page
    @RequestMapping("/admin/addPage")
    public String newPageForm(Model model) {


        if (!model.containsAttribute("page")) {
            model.addAttribute("page", new Page());
        }
        model.addAttribute("action", "/admin/addPage");

        List<Page> pages = pageService.findAll();
        model.addAttribute("pages", pages);

        return "admin/add_page";
    }

    // Process data from creating new page
    @RequestMapping(value = "/admin/addPage", method = RequestMethod.POST)

    public String processNewPageData(@Valid Page page, BindingResult result,
                                     RedirectAttributes redirectAttributes, HttpServletRequest request) {


        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.page", result);
            redirectAttributes.addFlashAttribute("page", page);


            return "redirect:/admin/addPage";
        }

        if (page.getSlug().length() < 1) {
            page.setSlug(slugify.slugify(page.getTitle()));
        }

        contentUtils.decodeFileIds(page);


        if (page.getParent().getId() < 1) {
            page.setParent(null);
        }

        pageService.save(page);
        redirectAttributes.addFlashAttribute("page", page);
        redirectAttributes.addFlashAttribute("flash",
                new FlashMessage("Page successfully added", FlashMessage.Status.SUCCESS));
        return "redirect:" + request.getServletPath();
    }


    // Edit page
    @RequestMapping("/admin/page/{id}/edit")
    public String editPageForm(@PathVariable Long id, Model model) {
        if (!model.containsAttribute("page")) {
            Page page = pageService.findById(id);
            model.addAttribute("page", page);
        }

        List<Page> pages = pageService.findAll();
        model.addAttribute("pages", pages);


        model.addAttribute("action", "/admin/page/" + id + "/edit");
        return "admin/add_page";
    }



    // Process data from editing page
    @RequestMapping(value = "/admin/page/{id}/edit", method = RequestMethod.POST)
    public String processEditPageData(@Valid Page page, BindingResult result,
                                      RedirectAttributes redirectAttributes, HttpServletRequest request) {


        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.page", result);
            redirectAttributes.addFlashAttribute("page", page);

            return "redirect:/admin/page/" + page.getId() + "/edit";
        }

        if (page.getSlug().length() < 1) {
            page.setSlug(slugify.slugify(page.getTitle()));
        }

        contentUtils.decodeFileIds(page);


        if (page.getParent().getId() < 1) {
            page.setParent(null);
        }

        pageService.save(page);

        redirectAttributes.addFlashAttribute("flash",
                new FlashMessage("Strona została wyedytowana", FlashMessage.Status.SUCCESS));

        return "redirect:" + request.getServletPath();
    }



    // Process data from editing post
    @RequestMapping(value = "/admin/pages/{id}/delete", method = RequestMethod.POST)
    public String processDeletePage(@PathVariable Long id, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        if (!request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/logout";
        }

        Page page = pageService.findById(id);
        pageService.delete(page);

        redirectAttributes.addFlashAttribute("flash",
                new FlashMessage("Strona została usunięta.", FlashMessage.Status.SUCCESS));

        return "redirect:/admin/pages";
    }


}
