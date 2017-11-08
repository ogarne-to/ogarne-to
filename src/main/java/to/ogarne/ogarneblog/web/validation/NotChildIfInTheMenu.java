package to.ogarne.ogarneblog.web.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {NotChildIfInTheMenuValidator.class})
public @interface NotChildIfInTheMenu {

    String message() default "You can't set the parent and the position in the menu at the same time";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
