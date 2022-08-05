package com.restaurants.restaurants.repositories;

import com.restaurants.restaurants.entities.RestaurantEntity;
import com.restaurants.restaurants.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long>, PagingAndSortingRepository<RestaurantEntity, Long> {
    UserEntity findByEmailId(String emailId);
}
