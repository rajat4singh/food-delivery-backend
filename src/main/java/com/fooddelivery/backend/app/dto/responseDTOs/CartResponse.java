package com.fooddelivery.backend.app.dto.responseDTOs;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartResponse {

    double cartTotal;

    List<MenuResponse> foodItems;

}
