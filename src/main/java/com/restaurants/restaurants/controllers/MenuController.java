package com.restaurants.restaurants.controllers;

import com.restaurants.restaurants.dtos.CreateMenuDto;
import com.restaurants.restaurants.dtos.HttpCreateResponseDto;
import com.restaurants.restaurants.entities.MenuEntity;
import com.restaurants.restaurants.services.MenuService;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/menus")
public class MenuController {
    @Autowired private MenuService menuService;

    @PostMapping("/add_menu")
    public ResponseEntity<String> createAMenu(@Valid @RequestBody CreateMenuDto createMenuDto) {
        boolean isCreated = menuService.registerAMenu(createMenuDto.getRestaurantId(), MenuEntity.builder()
                        .menuName(createMenuDto.getMenuName())
                        .foodType(createMenuDto.getFoodType())
                        .cuisineType(createMenuDto.getCuisineType())
                        .isSpecial(createMenuDto.isSpecial())
                        .availableFrom(createMenuDto.getAvailableForm())
//                        .restaurantId(createMenuDto.getRestaurantId())
                .build());

        if(!isCreated) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/add_special_menu")
    public ResponseEntity<String> createSpecialMenu(@RequestParam("file") MultipartFile specialMenu, @RequestParam Long restaurantId) throws IOException {
        InputStream inputStream = specialMenu.getInputStream();
        Reader inputReader = new InputStreamReader(inputStream);
        CsvParser parser = new CsvParser(new CsvParserSettings());
        List<String[]> parserRows = parser.parseAll(inputReader);
        parserRows.forEach(item -> {
            System.out.println(item[0]);
        });
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
