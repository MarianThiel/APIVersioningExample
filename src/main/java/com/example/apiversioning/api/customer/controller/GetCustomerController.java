package com.example.apiversioning.api.customer.controller;

import com.example.apiversioning.api.common.versioning.VersioningService;
import com.example.apiversioning.api.customer.dto.versioning.DtoV1;
import com.example.apiversioning.api.customer.dto.versioning.DtoV2;
import com.example.apiversioning.api.customer.dto.versioning.DtoV3;
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

    private VersioningService versioningService;

    @GetMapping(value = "/allCustomers", headers = "X-API-Version=1")
    public Mono<List<DtoV1>> getAllCustomersV1(){
        return getCustomerUseCase.getAllCustomers()
                .map(customers -> customers.stream()
                        .map(customer -> versioningService.fromCustomerDto(CustomerMapper.fromDomain(customer), DtoV1.class)).collect(Collectors.toList()));
    }
    @GetMapping(value = "/allCustomers", headers = "X-API-Version=2")
    public Mono<List<DtoV2>> getAllCustomersV2(){
        return getCustomerUseCase.getAllCustomers()
                .map(customers -> customers.stream()
                        .map(customer -> versioningService.fromCustomerDto(CustomerMapper.fromDomain(customer), DtoV2.class)).collect(Collectors.toList()));
    }
    @GetMapping(value = "/allCustomers", headers = "X-API-Version=3")
    public Mono<List<DtoV3>> getAllCustomersV3(){
        return getCustomerUseCase.getAllCustomers()
                .map(customers -> customers.stream()
                        .map(customer -> versioningService.fromCustomerDto(CustomerMapper.fromDomain(customer), DtoV3.class)).collect(Collectors.toList()));
    }
}
