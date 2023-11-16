package com.example.apiversioning.api.customer.dto;

import com.example.apiversioning.api.common.versioning.CustomerDtoVersionable;
import com.example.apiversioning.api.customer.dto.versioning.AddressDtoV2;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@AllArgsConstructor
public class CustomerDto {


    private String firstName;

    private String lastName;

    private int phoneNumber;

    private String email;

    private AddressDtoV2 address;


}
