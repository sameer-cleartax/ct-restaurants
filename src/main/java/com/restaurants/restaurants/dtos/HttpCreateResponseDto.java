package com.restaurants.restaurants.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HttpCreateResponseDto {
    private String message;
    private Integer statusCode;
}
