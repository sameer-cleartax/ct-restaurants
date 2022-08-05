package com.restaurants.restaurants.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RestaurantDto {
    private Long restaurantId;
    private String restaurantName;
    private String errorMessage;
    private Integer errorStatusCode;
}
