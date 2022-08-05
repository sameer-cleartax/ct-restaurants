package com.restaurants.restaurants.dtos;

import com.restaurants.restaurants.annotations.PasswordEqualConstraint;
import com.restaurants.restaurants.annotations.ValidEmail;
import com.restaurants.restaurants.annotations.ValidPassword;
import com.restaurants.restaurants.annotations.ValidPhoneNumber;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class RegisterRestaurantDto {
    private Long id;

    @NotEmpty(message = "Please enter restaurant name.")
    private String restaurantName;

    @NotEmpty(message = "Please enter email Id.")
    @ValidEmail
    private String emailId;

    @NotEmpty(message = "Please enter phone number.")
    @ValidPhoneNumber
    private String phoneNumber;

    @NotEmpty(message = "Please enter password.")
    @ValidPassword
    private String password;
}
