package com.example.apiversioning.api.customer.dto.versioning;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;

import static com.example.apiversioning.api.common.util.VersioningServiceProvider.addressVersioningService;

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
        return new CustomerDtoV4(
          firstName,
          lastName,
          phoneNumber,
          email,
          addressVersioningService.convertUp(address, AddressDtoV3.class)
        );
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
