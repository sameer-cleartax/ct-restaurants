package com.restaurants.restaurants.annotations;

import com.restaurants.restaurants.validations.PasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface ValidPassword {
    String message() default "Please enter correct password.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
