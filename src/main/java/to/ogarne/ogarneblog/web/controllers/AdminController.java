    package to.ogarne.ogarneblog.web.controllers;

    import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import to.ogarne.ogarneblog.model.Post;
import to.ogarne.ogarneblog.model.User;
import to.ogarne.ogarneblog.service.CategoryService;
import to.ogarne.ogarneblog.service.FileService;
import to.ogarne.ogarneblog.service.PostService;
import to.ogarne.ogarneblog.service.UserService;
import to.ogarne.ogarneblog.web.CategoryWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

    /**
     * Created by jedrz on 17.07.2017.
     */

    @Controller
    public class AdminController extends  RootController {

        @Autowired
        PostService postService;

        @Autowired
        UserService userService;

        @Autowired
        CategoryService categoryService;

        @Autowired
        FileService fileService;

        // Login admin

        @RequestMapping("/admin/login")
        public String logInForm(Model model, HttpServletRequest request) {
            try {
                Object flash = request.getSession().getAttribute("flash");
                model.addAttribute("flash", flash);
                model.addAttribute("user", new User());
                request.getSession().removeAttribute("flash");
            } catch (Exception ex) {
                // Do nothing
            }

            return "admin/login";
        }


        // Admin's control panel
        @RequestMapping("/admin")
        public String getAdminPanel (Model model){
            List<Post> posts = postService.findAll();
            Collections.reverse(posts);
            model.addAttribute("posts", posts);
            return "admin/panel";
        }





        // Edit menu
        @RequestMapping("/admin/editmenu")
        public String editMenuForm(Model model){
            CategoryWrapper categories = new CategoryWrapper();
            categories.setCategories(categoryService.findAll());
            model.addAttribute("wrapper", categories);
            return "admin/edit_menu";
        }



        // Get the result of menu editing
        @RequestMapping(value = "/admin/editmenu", method = RequestMethod.POST)
        public String processEditMenuData(@Valid @ModelAttribute CategoryWrapper wrapper, Model model) {
            categoryService.saveInBulk(wrapper.getCategories());
            return "redirect:/admin/editmenu";
        }



        // Get the image list

        @RequestMapping("/admin/images")
        public String showImageList(Model model) {
            model.addAttribute("images", fileService.findAllImages());

            return "admin/image_list";
        }


        // // Handles the case of user entering the same orderInMenu in two different places.
        // @ExceptionHandler({ConstraintViolationException.class})
        // public ModelAndView databaseError(HttpServletRequest req, Exception ex) {
        //     if (req.getServletPath().equals("/admin/editmenu")) {
        //         ModelAndView mav = new ModelAndView();
        //         mav.addObject("flash", new FlashMessage("Liczby nie mogą się powtarzać", FlashMessage.Status.FAILURE));
        //         CategoryWrapper wrapper = new CategoryWrapper();
        //         wrapper.setPages(categoryService.findAll());
        //         mav.addObject("wrapper", wrapper);
        //         mav.setViewName("/admin/edit_menu");
        //         return mav;
        //
        //     }
        //
        //     return null;
        // }
    }
