package com.example.apiversioning.api.customer.dto.versioning;

import com.example.apiversioning.api.common.versioning.CustomerDtoVersionable;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDtoV3 implements CustomerDtoVersionable {

    private String firstName;

    private String lastName;

    private int phoneNumber;

    private String email;

    @Nonnull private AddressDtoV2 address;

    @Override
    public CustomerDtoVersionable convertUp() {
        return this;
    }

    @Override
    public CustomerDtoVersionable convertDown() {

        return new CustomerDtoV2(
                firstName + " " + lastName,
                phoneNumber,
                address,
                address
        );
    }


}
