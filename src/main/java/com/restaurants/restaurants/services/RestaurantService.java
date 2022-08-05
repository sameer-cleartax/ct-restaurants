package com.restaurants.restaurants.services;

import com.restaurants.restaurants.entities.RestaurantEntity;
import com.restaurants.restaurants.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public RestaurantEntity registerRestaurant(RestaurantEntity restaurantEntity) throws Exception {
        return restaurantRepository.save(restaurantEntity);
    }

    public Page<RestaurantEntity> findAllRestaurants(final Integer page) {
        PageRequest paging = PageRequest.of(page, 10);
        return restaurantRepository.findAll(paging);
    }

}
