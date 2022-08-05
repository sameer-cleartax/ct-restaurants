package com.restaurants.restaurants.services;

import com.restaurants.restaurants.entities.MenuEntity;
import com.restaurants.restaurants.entities.RestaurantEntity;
import com.restaurants.restaurants.repositories.MenuRepository;
import com.restaurants.restaurants.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuService {
    @Autowired private MenuRepository menuRepository;
    @Autowired private RestaurantRepository restaurantRepository;

    public boolean registerAMenu(Long restaurantId, MenuEntity menuEntity) {
        Optional<RestaurantEntity> restaurantById = restaurantRepository.findById(restaurantId);
        if(!restaurantById.isPresent()) {
            return false;
        }
        RestaurantEntity restaurant = restaurantById.get();
        menuEntity.setRestaurant(restaurant);
        menuRepository.save(menuEntity);
        return true;
    }
}
