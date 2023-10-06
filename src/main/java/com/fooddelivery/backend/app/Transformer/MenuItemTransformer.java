package com.fooddelivery.backend.app.Transformer;

import com.fooddelivery.backend.app.dto.responseDTOs.MenuResponse;
import com.fooddelivery.backend.app.model.MenuItem;

public class MenuItemTransformer {

    public static MenuResponse MenuItemToMenuResponse(MenuItem menuItem){
        return MenuResponse.builder()
                .dishName(menuItem.getDishName())
                .category(menuItem.getCategory())
                .price(menuItem.getPrice())
                .veg(menuItem.isVeg())
                .build();
    }
}
