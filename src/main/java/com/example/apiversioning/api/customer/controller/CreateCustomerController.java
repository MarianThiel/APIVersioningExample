package com.example.apiversioning.api.customer.controller;

import com.example.apiversioning.api.common.conv.DtoConverter;
import com.example.apiversioning.api.customer.dto.CustomerDto;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoV1;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoV2;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoV3;
import com.example.apiversioning.core.usecase.CreateCustomerUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor

public class CreateCustomerController {

    private CreateCustomerUseCase createCustomerUseCase;

    private DtoConverter converter;

    @PostMapping(value = "/customers", headers = "X-API-Version=1")
    public Mono<Void> createCustomerV1(@RequestBody CustomerDtoV1 customer){
        return Mono.empty();
    }

    @PostMapping(value = "/customers", headers = "X-API-Version=2")
    public Mono<Void> createCustomerV2(@RequestBody CustomerDtoV2 customer){
        return Mono.empty();
    }

    @PostMapping(value = "/customers", headers = "X-API-Version=3")
    public Mono<Void> createCustomerV3(@RequestBody CustomerDtoV3 customer){
        return Mono.empty();
    }

    @PostMapping(value = "/customers", headers = "X-API-Version=4")
    public Mono<Void> createCustomerV4(@RequestBody CustomerDto customer){
        return Mono.empty();
    }
}
