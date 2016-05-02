package olegshan.agg.jba.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Bors on 30.04.2016.
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = {UniqueUserNameValidator.class})
public @interface UniqueUsername {

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
