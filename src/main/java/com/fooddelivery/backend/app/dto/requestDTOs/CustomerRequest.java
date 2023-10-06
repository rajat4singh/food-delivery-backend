package com.fooddelivery.backend.app.dto.requestDTOs;

import com.fooddelivery.backend.app.enums.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerRequest {

    String name;

    String email;

    String mobileNo;

    String address;

    Gender gender;
}
