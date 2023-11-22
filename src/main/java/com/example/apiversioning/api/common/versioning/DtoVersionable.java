package com.example.apiversioning.api.common.versioning;

public interface DtoVersionable<S extends DtoVersionable<?>> {

    S convertUp();

    S convertDown();


}
