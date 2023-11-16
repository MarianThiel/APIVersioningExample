package com.example.apiversioning.api.common.versioning;

public interface CustomerDtoVersionable {

    CustomerDtoVersionable convertUp();

    CustomerDtoVersionable convertDown();


}
