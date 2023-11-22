package com.example.apiversioning.api.order.dto;

public class OrderDto implements OrderDtoVersionable{
    @Override
    public OrderDtoVersionable convertUp() {
        return null;
    }

    @Override
    public OrderDtoVersionable convertDown() {
        return null;
    }
}
