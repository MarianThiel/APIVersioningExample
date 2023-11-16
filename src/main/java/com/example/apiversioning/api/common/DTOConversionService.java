package com.example.apiversioning.api.common;

import com.example.apiversioning.api.customer.dto.CustomerDto;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoV2;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoV3;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class DTOConversionService {

    private final Map<Class<?>, Function<?, ?>> conversionMap = new HashMap<>();


    public <T, R> void addConversion(Class<T> sourceVersion, Class<R> targetVersion, Function<T, R> converter) {
        conversionMap.put(sourceVersion, converter);
    }

    public <T, R> R convertTo(T dto, Class<R> targetVersion) {
        if (dto == null) {
            throw new IllegalArgumentException("Input DTO darf nicht null sein");
        }

        @SuppressWarnings("unchecked")
        Function<T, R> converter = (Function<T, R>) conversionMap.get(dto.getClass());
        return converter.apply(dto);
    }


}