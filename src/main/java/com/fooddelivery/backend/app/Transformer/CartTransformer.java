package com.fooddelivery.backend.app.Transformer;

import com.fooddelivery.backend.app.dto.responseDTOs.CartResponse;
import com.fooddelivery.backend.app.model.Cart;

import java.util.ArrayList;

public class CartTransformer {
    public static CartResponse CartToCartResponse(Cart cart){
        return CartResponse.builder()
                .cartTotal(cart.getCartTotal())
                .foodItems(new ArrayList<>())
                .build();
    }
}
