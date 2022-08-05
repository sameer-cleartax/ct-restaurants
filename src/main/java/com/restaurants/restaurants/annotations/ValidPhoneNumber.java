package com.restaurants.restaurants.annotations;

import com.restaurants.restaurants.validations.PhoneNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = PhoneNumberValidator.class)
public @interface ValidPhoneNumber {
    String message() default "Please enter correct phone number.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
