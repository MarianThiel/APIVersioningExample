package com.example.apiversioning.api.customer.dto;

import com.example.apiversioning.api.customer.dto.versioning.AddressDtoV2;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CustomerDto {

    private String firstName;

    private String lastName;

    private int phoneNumber;

    private String email;

    private List<AddressDtoV2> firstAddress;

    @Override
    public String toString() {
        return "CustomerDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", firstAddress=" + firstAddress +
                '}';
    }
}
