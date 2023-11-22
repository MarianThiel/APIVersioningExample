package com.example.apiversioning.api.order.dto.versioning;

import com.example.apiversioning.api.order.dto.OrderDtoVersionable;

public class OrderDtoV1 implements OrderDtoVersionable {
    @Override
    public OrderDtoVersionable convertUp() {
        return null;
    }

    @Override
    public OrderDtoVersionable convertDown() {
        return null;
    }
}
