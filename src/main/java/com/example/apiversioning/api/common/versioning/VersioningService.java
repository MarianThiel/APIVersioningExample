package com.example.apiversioning.api.common.versioning;

import com.example.apiversioning.api.customer.dto.CustomerDto;
import com.example.apiversioning.api.customer.dto.versioning.CustomerDtoVersionable;
import org.springframework.stereotype.Service;


/**
 * Problematic at runtime, requires to chain all Versionable objects together.
 * Also cyclic chaining is possible as well as none reachable versions
 */
@Service
public class VersioningService<C extends DtoVersionable<C>, B extends VersioningBase<H>, H extends HighestVersionable<B>> {
    private final Class<? extends C> highestVersion;

    public VersioningService(Class<? extends C> highestVersion) {
        this.highestVersion = highestVersion;
    }

    public <T extends DtoVersionable<C>> T convertUp(C input, Class<T> target) {

        C current = input;
        C prev = null;
        while(prev != current){
            if(target.isInstance(current)){
                //noinspection unchecked
                return (T) current;
            }
            prev = current;
            current = current.convertUp();

        }
        if(current.getClass().isInstance(target)){
            //noinspection unchecked
            return (T) current;
        }

        throw new IllegalStateException(("target class %s is not reachable").formatted(target));
    }

    public <T extends DtoVersionable<C>> T convertDown(C input, Class<T> target) {

        C current = input;
        C prev = null;
        while(prev != current){
            if(target.isInstance(current)){
                //noinspection unchecked
                return (T) current;
            }
            prev = current;
            current = current.convertDown();

        }
        if(current.getClass().isInstance(target)){
            //noinspection unchecked
            return (T) current;
        }

        throw new IllegalStateException(("target class %s is not reachable").formatted(target));
    }

    public B toBaseDto(C inputCustomerDto){
        C highestVersionDto = convertUp(inputCustomerDto, highestVersion);
        if( highestVersionDto instanceof HighestVersionable<?>){
            @SuppressWarnings("unchecked") HighestVersionable<B> versionDto = (HighestVersionable<B>) highestVersionDto;
            return versionDto.toBaseDto();
        }

        throw new IllegalStateException("Could not convert to highest version");
    }

    public CustomerDto toCustomerDto(CustomerDtoVersionable customer) {
        return null;
    }
}
