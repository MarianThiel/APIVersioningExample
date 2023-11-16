package com.example.apiversioning;

import com.example.apiversioning.api.common.conv.Adapter;
import com.example.apiversioning.api.common.conv.DtoConverter;
import com.example.apiversioning.api.common.conv.adapter.CustomerDtoV1V2Adapter;
import com.example.apiversioning.api.common.conv.adapter.CustomerDtoV2V3Adapter;
import com.example.apiversioning.api.common.conv.adapter.CustomerDtoV3V4Adapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public DtoConverter customerDtoConverter(){

        Adapter<?,?>[] adapters = {
                new CustomerDtoV1V2Adapter(),
                new CustomerDtoV2V3Adapter(),
                new CustomerDtoV3V4Adapter()
        };

        return new DtoConverter(adapters);

    }
}
