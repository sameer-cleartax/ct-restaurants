package com.restaurants.restaurants.validations;

import com.restaurants.restaurants.annotations.ValidPassword;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.RuleResult;
import org.passay.WhitespaceRule;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {
    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        org.passay.PasswordValidator passwordValidator = new org.passay.PasswordValidator(Arrays.asList(
                new LengthRule(6, 255),
                new WhitespaceRule()
        ));

        RuleResult result = passwordValidator.validate(new PasswordData(password));
        if( result.isValid() )
            return true;
        List<String> messages = passwordValidator.getMessages(result);
        String messageTemplate = messages.stream().collect(Collectors.joining(","));
        context.buildConstraintViolationWithTemplate(messageTemplate).addConstraintViolation().disableDefaultConstraintViolation();
        return false;
    }
}
