package com.fooddelivery.backend.app.service;

import com.fooddelivery.backend.app.Transformer.RestaurantTransformer;
import com.fooddelivery.backend.app.dto.requestDTOs.RestaurantRequest;
import com.fooddelivery.backend.app.dto.responseDTOs.RestaurantResponse;
import com.fooddelivery.backend.app.model.Restaurant;
import com.fooddelivery.backend.app.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class RestaurantService {
    final RestaurantRepository restaurantRepository;

    /**
     * Constructor injection
     * @param restaurantRepository
     */
    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository){
        this.restaurantRepository=restaurantRepository;
    }


    public RestaurantResponse addRestaurant(RestaurantRequest restaurantRequest) {

        Restaurant restaurant= RestaurantTransformer.RestaurantRequestToRestaurant(restaurantRequest);

        Restaurant savedRestaurant =restaurantRepository.save(restaurant);

        return RestaurantTransformer.RestaurantToRestaurantResponse(savedRestaurant);
    }
}
