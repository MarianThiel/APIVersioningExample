package com.example.apiversioning.api.common.versioning;

public interface DtoVersionable {

    DtoVersionable convertUp();

    DtoVersionable convertDown();


}
