package com.restaurants.restaurants.controllers;

import com.restaurants.restaurants.dtos.RestaurantDto;
import com.restaurants.restaurants.entities.RestaurantEntity;
import com.restaurants.restaurants.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/restaurant")
public class RestaurantController {

    @Autowired private RestaurantService restaurantService;
    @GetMapping("/get_all_restaurants")
    public ResponseEntity<Page<RestaurantEntity>> allRestaurants(@RequestParam(required = false) Integer page) {
        if(page == null)
            page = 0;
        return ResponseEntity.ok(restaurantService.findAllRestaurants(page));
    }
}
