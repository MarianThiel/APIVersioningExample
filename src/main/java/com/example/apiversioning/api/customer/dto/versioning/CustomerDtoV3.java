package com.example.apiversioning.api.customer.dto.versioning;

import com.example.apiversioning.api.common.versioning.HighestVersionable;
import com.example.apiversioning.api.customer.dto.AddressDto;
import com.example.apiversioning.api.customer.dto.CustomerDto;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDtoV3 implements CustomerDtoVersionable, HighestVersionable<CustomerDto> {

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


    @Override
    public CustomerDto toBaseDto() {
        return new CustomerDto(
                getFirstName(),
                getLastName(),
                getPhoneNumber(),
                getEmail(),
                new AddressDto(
                        getAddress().getCity(),
                        getAddress().getAddressLine(),
                        getAddress().getAddressLine2()
                )
        );
    }
}
