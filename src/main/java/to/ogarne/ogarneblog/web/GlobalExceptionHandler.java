package to.ogarne.ogarneblog.web;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import to.ogarne.ogarneblog.service.CategoryService;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    CategoryService categoryService;

    //StandardServletMultipartResolver
    @ExceptionHandler({MultipartException.class})
    public String handleMultipartException(MultipartException e, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        if (request.getServletPath().equals("/admin/addFile")) {
            redirectAttributes.addFlashAttribute("flash", new FlashMessage("Plik jest za duży", FlashMessage.Status.FAILURE));
            return "redirect:/admin/addFile";
        }

    return null;
    }

    // Handles the case of user entering the same orderInMenu in two different places.
    @ExceptionHandler({ConstraintViolationException.class})
    public String databaseErrorHandler(Exception e, RedirectAttributes redirectAttributes, HttpServletRequest req) {
        if (req.getServletPath().equals("/admin/editmenu")) {
            redirectAttributes.addFlashAttribute("flash", new FlashMessage("Liczby nie mogą się powtarzać", FlashMessage.Status.FAILURE));
            CategoryWrapper wrapper = new CategoryWrapper();
            wrapper.setCategories(categoryService.findAll());
            redirectAttributes.addFlashAttribute("wrapper", wrapper);
            return "redirect:/admin/editmenu";
        }

        return null;
    }



}
