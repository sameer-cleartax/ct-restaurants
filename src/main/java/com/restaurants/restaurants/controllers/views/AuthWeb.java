package com.restaurants.restaurants.controllers.views;

import com.restaurants.restaurants.dtos.RegisterRestaurantDto;
import com.restaurants.restaurants.dtos.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class AuthWeb {
    @GetMapping("/register-a-user")
    public String showRegisterAUserForm(WebRequest request, Model model) {
        UserRegistrationDto register = new UserRegistrationDto();
        model.addAttribute("user", register);
        return "user_register";
    }

    @GetMapping("/register-a-restaurant")
    public String showRegisterARestaurantForm(WebRequest request, Model model) {
        RegisterRestaurantDto registerDto = new RegisterRestaurantDto();
        model.addAttribute("restaurant", registerDto);
        return "restaurant_register";
    }

    @GetMapping("/")
    public String showHome(WebRequest request, Model model) {
        return "home";
    }
}
