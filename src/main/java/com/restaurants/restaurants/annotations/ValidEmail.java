package com.restaurants.restaurants.annotations;

import com.restaurants.restaurants.validations.EmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
public @interface ValidEmail {
    String message() default "Please provide valid emailId.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
