package com.example.apiversioning.api.customer.dto.versioning;

import com.example.apiversioning.api.common.versioning.DtoVersionable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DtoV2 implements DtoVersionable {

    private String name;

    private int phoneNumber;

    private AddressDtoV2 firstAddress;

    private AddressDtoV2 secondAddress;

    @Override
    public DtoVersionable convertUp() {
        return new DtoV3(
                name,
                "N/A",
                phoneNumber,
                "N/A",
                new AddressDtoV2(
                        firstAddress.getCity(),
                        firstAddress.getAddressLine(),
                        "N/A"
                )
        );
    }

    @Override
    public DtoVersionable convertDown() {
        return new DtoV1(
                name,
                phoneNumber,
                new AddressDtoV1(
                        firstAddress.getCity(),
                        firstAddress.getAddressLine()
                )
        );
    }


}
