package com.restaurants.restaurants.annotations;

import com.restaurants.restaurants.validations.PasswordEqualConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = PasswordEqualConstraintValidator.class)
public @interface PasswordEqualConstraint {
    String message() default "Field values don't match.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String field();
    String fieldMatch();
    @Target({ElementType.TYPE })
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        PasswordEqualConstraint[] value();
    }
}
