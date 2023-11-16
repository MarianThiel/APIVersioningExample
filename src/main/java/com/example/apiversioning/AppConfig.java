package com.example.apiversioning;

import com.example.apiversioning.api.common.conv.ObjectTransformer;
import com.example.apiversioning.api.common.conv.DtoConverter;
import com.example.apiversioning.api.common.conv.adapter.CustomerDtoV1V2ObjectTransformer;
import com.example.apiversioning.api.common.conv.adapter.CustomerDtoV2V3ObjectTransformer;
import com.example.apiversioning.api.common.conv.adapter.CustomerDtoV3V4ObjectTransformer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public DtoConverter customerDtoConverter(){

        ObjectTransformer<?,?>[] objectTransformers = {
                new CustomerDtoV1V2ObjectTransformer(),
                new CustomerDtoV2V3ObjectTransformer(),
                new CustomerDtoV3V4ObjectTransformer()
        };

        return new DtoConverter(objectTransformers);

    }
}
