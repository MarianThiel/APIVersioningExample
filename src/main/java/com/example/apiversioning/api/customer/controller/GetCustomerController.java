package com.example.apiversioning.api.customer.controller;

import com.example.apiversioning.api.common.versioning.VersioningService;
import com.example.apiversioning.api.common.versioning.VersioningServiceFactory;
import com.example.apiversioning.api.customer.dto.CustomerDto;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoV1;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoV2;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoV3;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoVersionable;
import com.example.apiversioning.api.customer.mapper.CustomerMapper;
import com.example.apiversioning.core.usecase.GetCustomerUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GetCustomerController {

    private final GetCustomerUseCase getCustomerUseCase;

    private final VersioningService<CustomerDtoVersionable, CustomerDto, CustomerDtoV3> versioningService;

    public GetCustomerController(GetCustomerUseCase getCustomerUseCase) {
        this.getCustomerUseCase = getCustomerUseCase;
        versioningService = VersioningServiceFactory.createCustomerVersioningService();
    }

    @GetMapping(value = "/allCustomers", headers = "X-API-Version=1")
    public Mono<List<CustomerDtoV1>> getAllCustomersV1(){
        return getCustomerUseCase.getAllCustomers()
                .map(customers -> customers.stream()
                        .map(customer -> versioningService.fromBaseDtoToSpecificVersion(CustomerMapper.fromDomain(customer), CustomerDtoV1.class)).collect(Collectors.toList()));
    }
    @GetMapping(value = "/allCustomers", headers = "X-API-Version=2")
    public Mono<List<CustomerDtoV2>> getAllCustomersV2(){
        return getCustomerUseCase.getAllCustomers()
                .map(customers -> customers.stream()
                        .map(customer -> versioningService.fromBaseDtoToSpecificVersion(CustomerMapper.fromDomain(customer), CustomerDtoV2.class)).collect(Collectors.toList()));
    }
    @GetMapping(value = "/allCustomers", headers = "X-API-Version=3")
    public Mono<List<CustomerDtoV3>> getAllCustomersV3(){
        return getCustomerUseCase.getAllCustomers()
                .map(customers -> customers.stream()
                        .map(customer -> versioningService.fromBaseDtoToSpecificVersion(CustomerMapper.fromDomain(customer), CustomerDtoV3.class)).collect(Collectors.toList()));
    }

}
