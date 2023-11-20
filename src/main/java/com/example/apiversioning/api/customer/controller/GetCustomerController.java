package com.example.apiversioning.api.customer.controller;

import com.example.apiversioning.api.common.versioning.CustomerVersioningService;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoV1;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoV2;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoV3;
import com.example.apiversioning.api.customer.mapper.CustomerMapper;
import com.example.apiversioning.core.usecase.GetCustomerUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class GetCustomerController {

    private GetCustomerUseCase getCustomerUseCase;

    private CustomerVersioningService customerVersioningService;

    @GetMapping(value = "/allCustomers", headers = "X-API-Version=1")
    public Mono<List<CustomerDtoV1>> getAllCustomersV1(){
        return getCustomerUseCase.getAllCustomers()
                .map(customers -> customers.stream()
                        .map(customer -> customerVersioningService.fromCustomerDto(CustomerMapper.fromDomain(customer), CustomerDtoV1.class)).collect(Collectors.toList()));
    }
    @GetMapping(value = "/allCustomers", headers = "X-API-Version=2")
    public Mono<List<CustomerDtoV2>> getAllCustomersV2(){
        return getCustomerUseCase.getAllCustomers()
                .map(customers -> customers.stream()
                        .map(customer -> customerVersioningService.fromCustomerDto(CustomerMapper.fromDomain(customer), CustomerDtoV2.class)).collect(Collectors.toList()));
    }
    @GetMapping(value = "/allCustomers", headers = "X-API-Version=3")
    public Mono<List<CustomerDtoV3>> getAllCustomersV3(){
        return getCustomerUseCase.getAllCustomers()
                .map(customers -> customers.stream()
                        .map(customer -> customerVersioningService.fromCustomerDto(CustomerMapper.fromDomain(customer), CustomerDtoV3.class)).collect(Collectors.toList()));
    }
}
