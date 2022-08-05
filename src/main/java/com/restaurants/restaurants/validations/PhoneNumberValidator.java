package com.restaurants.restaurants.validations;

import com.restaurants.restaurants.annotations.ValidPhoneNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {
    private Pattern pattern;
    private Matcher matcher;
    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        pattern = Pattern.compile("^[0-9]{10}$");
        matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
