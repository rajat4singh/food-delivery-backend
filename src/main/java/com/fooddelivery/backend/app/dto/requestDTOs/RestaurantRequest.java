package com.fooddelivery.backend.app.dto.requestDTOs;

import com.fooddelivery.backend.app.enums.RestaurantCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RestaurantRequest {

    String name;

    RestaurantCategory restaurantCategory;

    String location;

    String contact;

}