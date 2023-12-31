package com.example.apiversioning.api.customer.controller;


import com.example.apiversioning.api.common.versioning.VersioningService;
import com.example.apiversioning.api.common.versioning.VersioningServiceFactory;
import com.example.apiversioning.api.customer.dto.CustomerDto;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoV1;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoV2;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoV3;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoVersionable;
import com.example.apiversioning.api.customer.mapper.CustomerMapper;
import com.example.apiversioning.core.entities.Customer;
import com.example.apiversioning.core.usecase.CreateCustomerUseCase;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Nonnull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController

public class CreateCustomerController {

    private final CreateCustomerUseCase createCustomerUseCase;

    private final VersioningService<CustomerDtoVersionable, CustomerDto, CustomerDtoV3> versioningService;

    public CreateCustomerController(CreateCustomerUseCase createCustomerUseCase){
        this.createCustomerUseCase = createCustomerUseCase;
        versioningService = VersioningServiceFactory.createCustomerVersioningService();
    }

    @Operation(summary = "Create Customer (Version 3)")
    @PostMapping(value = "/customers", headers = "X-API-Version=1")
    public Mono<Void> createCustomerV1(@RequestBody CustomerDtoV1 customer){
        CustomerDto customerDto = versioningService.toBaseDto(customer);
        Customer domainCustomer = CustomerMapper.toDomain(customerDto);
        return createCustomerUseCase.createCustomer(domainCustomer);
    }

    @PostMapping(value = "/customers", headers = "X-API-Version=2")
    public Mono<Void> createCustomerV2(@RequestBody CustomerDtoV2 customer){
        CustomerDto customerDto = versioningService.toBaseDto(customer);
        Customer domainCustomer = CustomerMapper.toDomain(customerDto);
        return createCustomerUseCase.createCustomer(domainCustomer);
    }

    @PostMapping(value = "/customers", headers = "X-API-Version=3")
    public Mono<Void> createCustomerV3(@RequestBody @Nonnull CustomerDtoV3 customer){
        CustomerDto customerDto = versioningService.toBaseDto(customer);
        Customer domainCustomer = CustomerMapper.toDomain(customerDto);
        return createCustomerUseCase.createCustomer(domainCustomer);
    }

}
