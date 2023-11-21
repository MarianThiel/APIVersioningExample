package com.example.apiversioning.api.customer.dto.versioning;

import com.example.apiversioning.api.common.versioning.DtoVersionable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DtoV1 implements DtoVersionable {

    private String name;

    private int phoneNumber;

    private AddressDtoV1 firstAddress;

    @Override
    public DtoVersionable convertUp() {
        return new DtoV2(
                name,
                phoneNumber,
                new AddressDtoV2(
                        firstAddress.getCity(),
                        firstAddress.getAddressLine(),
                        "N/A"
                ),
                new AddressDtoV2(
                        firstAddress.getCity(),
                        firstAddress.getAddressLine(),
                        "N/A"
                )
        );
    }

    @Override
    public DtoVersionable convertDown() {
        return this;
    }


}
