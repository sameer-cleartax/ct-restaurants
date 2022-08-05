package com.restaurants.restaurants.dtos;

import com.restaurants.restaurants.annotations.ValidEmail;
import com.restaurants.restaurants.annotations.ValidPassword;
import com.restaurants.restaurants.annotations.ValidPhoneNumber;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserRegistrationDto {
    private Long Id;
    @NotEmpty(message = "Please enter your name")
    private String name;

    @NotEmpty(message = "Please enter your name")
    @ValidEmail
    private String emailId;

    @NotEmpty(message = "Please enter your phone number.")
    @ValidPhoneNumber
    private String phoneNumber;

    @NotEmpty(message = "Please enter password")
    @ValidPassword
    private String password;
}
