package to.ogarne.ogarneblog.web.validation;

import to.ogarne.ogarneblog.model.Page;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotChildIfInTheMenuValidator implements ConstraintValidator<NotChildIfInTheMenu, Page> {

    @Override
    public void initialize(NotChildIfInTheMenu constraintAnnotation) {

    }

    @Override
    public boolean isValid(Page page, ConstraintValidatorContext context) {

        if (page.isPublished()) {
            return (page.getParent() == null || page.getParent().getId() == 0) || page.getMenuPosition()  == null;
        } else {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Page unpublished!").addConstraintViolation();
            return (page.getParent() == null || page.getParent().getId() == 0) && page.getMenuPosition() == null;
        }

    }
}
