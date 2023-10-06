package com.fooddelivery.backend.app.Transformer;

import com.fooddelivery.backend.app.dto.requestDTOs.CustomerRequest;
import com.fooddelivery.backend.app.dto.responseDTOs.CartResponse;
import com.fooddelivery.backend.app.dto.responseDTOs.CustomerResponse;
import com.fooddelivery.backend.app.model.Customer;

public class CustomerTransformer {

    public static Customer CustomerRequestToCustomer(CustomerRequest customerRequest){
        return Customer.builder()
                .name(customerRequest.getName())
                .email(customerRequest.getEmail())
                .address(customerRequest.getAddress())
                .mobileNo(customerRequest.getMobileNo())
                .gender(customerRequest.getGender())
                .build();
    }
    public static CustomerResponse CustomerToCustomerResponse(Customer customer){
        CartResponse cartResponse= CartTransformer.CartToCartResponse(customer.getCart());
        return CustomerResponse.builder()
                .name(customer.getName())
                .address(customer.getAddress())
                .mobileNo(customer.getMobileNo())
                .cart(cartResponse)
                .build();
    }
}
