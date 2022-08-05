package com.restaurants.restaurants.controllers;

import com.restaurants.restaurants.dtos.RegisterRestaurantDto;
import com.restaurants.restaurants.dtos.RestaurantDto;
import com.restaurants.restaurants.dtos.UserRegistrationDto;
import com.restaurants.restaurants.entities.PrivilegeEntity;
import com.restaurants.restaurants.entities.RestaurantEntity;
import com.restaurants.restaurants.entities.RoleEntity;
import com.restaurants.restaurants.entities.UserEntity;
import com.restaurants.restaurants.enums.PrivilegeEnum;
import com.restaurants.restaurants.enums.RoleEnum;
import com.restaurants.restaurants.services.RestaurantService;
import com.restaurants.restaurants.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/v1/auth")
public class AuthController {
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RestaurantService restaurantService;

    @PostMapping("/register-a-user")
    public String registerAUser(@Valid @ModelAttribute("user") UserRegistrationDto userDto,
                                            BindingResult bindingResult, Model model) {
        if( bindingResult.hasErrors()) {
            //return new ModelAndView("user_register", "error", userDto);
        }
        try {
            RoleEntity role = new RoleEntity();
            role.setRoleName(RoleEnum.USER);
            userService.register(UserEntity.builder()
                    .emailId(userDto.getEmailId())
                    .name(userDto.getName())
                    .password(passwordEncoder.encode(userDto.getPassword()))
                    .phoneNumber(userDto.getPhoneNumber())
                    .role(role)
                    .build()
            );
        } catch (Exception e) {
            System.out.println(e);
            return "error";
        }
        return "redirect:home";
    }

    @PostMapping("/register-a-restaurant")
    public ResponseEntity<RestaurantDto> registerARestaurant(@Valid @ModelAttribute("restaurant")RegisterRestaurantDto restaurantDto,
                                                             BindingResult bindingResult, Model model) {
        try {
            List<PrivilegeEntity> privileges = new ArrayList<>();
            privileges.add(new PrivilegeEntity(PrivilegeEnum.WRITE));
            privileges.add(new PrivilegeEntity(PrivilegeEnum.READ));
            privileges.add(new PrivilegeEntity(PrivilegeEnum.DELETE));
            privileges.add(new PrivilegeEntity(PrivilegeEnum.UPDATE));

            RoleEntity role = new RoleEntity();
            role.setRoleName(RoleEnum.RESTAURANT_OWNER);
            role.setPrivileges(privileges);
            userService.register(UserEntity.builder()
                    .emailId(restaurantDto.getEmailId())
                    .name(restaurantDto.getRestaurantName())
                    .phoneNumber(restaurantDto.getPhoneNumber())
                    .password(passwordEncoder.encode(restaurantDto.getPassword()))
                    .role(role)
                    .build()
            );
             RestaurantEntity restaurant = restaurantService.registerRestaurant(RestaurantEntity.builder()
                            .restaurantName(restaurantDto.getRestaurantName())
                            .emailId(restaurantDto.getEmailId())
                            .phoneNumber(restaurantDto.getPhoneNumber())
                            .isOpen(true)
                    .build());
            return ResponseEntity.ok(RestaurantDto.builder()
                    .restaurantId(restaurant.getId())
                    .restaurantName(restaurant.getRestaurantName()).build());

        } catch (Exception e) {
            System.out.println(e);
        }
        return ResponseEntity.badRequest().body(RestaurantDto.builder().errorStatusCode(404).errorMessage("Bad Request").build());
    }


}
