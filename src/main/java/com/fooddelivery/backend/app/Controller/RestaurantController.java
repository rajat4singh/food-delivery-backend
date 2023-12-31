package com.fooddelivery.backend.app.Controller;

import com.fooddelivery.backend.app.dto.requestDTOs.RestaurantRequest;
import com.fooddelivery.backend.app.dto.responseDTOs.RestaurantResponse;
import com.fooddelivery.backend.app.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


    @RestController
    @RequestMapping("/restaurant")
    public class RestaurantController {

        final RestaurantService restaurantService;

        /**
         * Constructor injection
         *
         * @param restaurantService
         */
        @Autowired
        public RestaurantController(RestaurantService restaurantService) {
            this.restaurantService = restaurantService;
        }

        @PostMapping("/add")
        public ResponseEntity addRestaurant(@RequestBody RestaurantRequest restaurantRequest) {

            RestaurantResponse restaurantResponse = restaurantService.addRestaurant(restaurantRequest);
            return new ResponseEntity(restaurantResponse, HttpStatus.CREATED);
        }
    }
