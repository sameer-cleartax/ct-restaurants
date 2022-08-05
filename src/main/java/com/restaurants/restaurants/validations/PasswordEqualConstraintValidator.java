package com.restaurants.restaurants.validations;

import com.restaurants.restaurants.annotations.PasswordEqualConstraint;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordEqualConstraintValidator implements ConstraintValidator<PasswordEqualConstraint, Object> {
    private String field;
    private String fieldMatch;

    @Override
    public void initialize(PasswordEqualConstraint constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.fieldMatch = constraintAnnotation.fieldMatch();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Object fieldValue = new BeanWrapperImpl(value).getPropertyValue(field);
        System.out.println(fieldValue);
        Object fieldMatchValue = new BeanWrapperImpl(value).getPropertyValue(fieldMatch);
        System.out.println(fieldMatchValue);
        if(fieldValue != null) {
            return fieldValue.equals(fieldMatchValue);
        }
        return false;
    }
}
