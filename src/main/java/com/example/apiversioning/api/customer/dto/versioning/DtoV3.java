package com.example.apiversioning.api.customer.dto.versioning;

import com.example.apiversioning.api.common.versioning.DtoVersionable;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DtoV3 implements DtoVersionable {

    private String firstName;

    private String lastName;

    private int phoneNumber;

    private String email;

    @Nonnull private AddressDtoV2 address;

    @Override
    public DtoVersionable convertUp() {
        return this;
    }

    @Override
    public DtoVersionable convertDown() {

        return new DtoV2(
                firstName + " " + lastName,
                phoneNumber,
                address,
                address
        );
    }


}
