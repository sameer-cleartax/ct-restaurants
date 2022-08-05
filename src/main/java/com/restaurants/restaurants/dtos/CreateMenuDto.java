package com.restaurants.restaurants.dtos;

import com.restaurants.restaurants.enums.CuisineType;
import com.restaurants.restaurants.enums.FoodType;
import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class CreateMenuDto {
    private Long restaurantId;

    private String menuName;

    private CuisineType cuisineType;

    private FoodType foodType;

    private boolean isSpecial = false;

    private Date availableForm;
}
