package com.example.apiversioning.core.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Address {

    private String city;
    private String addressLine;
    private String addressLine2;

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", addressLine='" + addressLine + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                '}';
    }
}
