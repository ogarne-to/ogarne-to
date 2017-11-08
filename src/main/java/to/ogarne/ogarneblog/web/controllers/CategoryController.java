package to.ogarne.ogarneblog.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import to.ogarne.ogarneblog.model.Category;
import to.ogarne.ogarneblog.service.CategoryNotEmptyException;
import to.ogarne.ogarneblog.service.CategoryService;
import to.ogarne.ogarneblog.service.PostService;
import to.ogarne.ogarneblog.web.FlashMessage;
import to.ogarne.ogarneblog.web.MarkdownParser;
import to.ogarne.ogarneblog.web.Pagination;
import to.ogarne.ogarneblog.web.Parseable;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class CategoryController extends  RootController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    PostService postService;

    @Autowired
    MarkdownParser markdownParser;

    @RequestMapping("/categories/{categoryName}")
    public String getPostsFromCategory(@PathVariable String categoryName, Model model,
                                       @PageableDefault(value=10, page = 0) Pageable pageable) {
        Category category = categoryService.findByName(categoryName);

        List<Parseable> posts = postService.findPostsInCategory(pageable, category.getId()).stream()
                .map(markdownParser::limit)
                .map(markdownParser::parse)
                .collect(Collectors.toList());


        model.addAttribute("pagination", new Pagination(pageable, postService.getCount(true, category.getId())));
        model.addAttribute("posts", posts);
        model.addAttribute("category", category);
        model.addAttribute("paginationPath", "categories/" + category.getName());


        return "post_list";


    }

    @RequestMapping("/admin/categories")
    public String showCategoryList(Model model) {
        model.addAttribute("categories", categoryService.findAll() );

        return "admin/category_list";
    }

    @RequestMapping("/admin/addCategory")
    public String formAddCategory (Model model) {

        if (!model.containsAttribute("category")) {
            model.addAttribute("category", new Category());

        }


        return "admin/add_category";
    }

    @RequestMapping(value = "/admin/addCategory", method = RequestMethod.POST)
    public String processAddCategory (@Valid Category category, BindingResult bindingResult, Model model,
                                      RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.category", bindingResult);
            redirectAttributes.addFlashAttribute("category", category);
            return "redirect:/admin/addCategory";
        }

        categoryService.save(category);

        redirectAttributes.addFlashAttribute("flash", new FlashMessage("Category added", FlashMessage.Status.SUCCESS));

        return "redirect:/admin/categories";
    }

    @RequestMapping("/admin/categories/{name}/edit")
    public String formEditCategory(@PathVariable String name,  Model model, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("category", categoryService.findByName(name));

        return "redirect:/admin/addCategory";


    }

    @RequestMapping(value = "/admin/categories/{name}/delete", method = RequestMethod.POST)
    public String deleteCategory(@PathVariable String name,  Model model, RedirectAttributes redirectAttributes) {

        Category category = categoryService.findByName(name);
        categoryService.delete(category);

        return "redirect:/admin/categories";


    }

    @ExceptionHandler({CategoryNotEmptyException.class})
    public String handleCategoryNotEmptyException(Exception e, Model model, HttpServletRequest request) {

        model.addAttribute("flash", new FlashMessage("Category not empty!", FlashMessage.Status.FAILURE));
        model.addAttribute("categories", categoryService.findAll() );

        return "/admin/category_list";

    }





}
