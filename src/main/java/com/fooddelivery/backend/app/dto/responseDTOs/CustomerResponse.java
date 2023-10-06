package com.fooddelivery.backend.app.dto.responseDTOs;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerResponse {

    String name;

    String mobileNo;

    String address;

    CartResponse cart;

}
