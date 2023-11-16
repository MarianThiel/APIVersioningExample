package com.example.apiversioning.api.common.versioning;

/**
 * Problematic at runtime, requires to chain all Versionable objects together.
 * Also cyclic chaining is possible as well as none reachable versions
 */
public class CustomerVersioningService {


    public static <T extends CustomerDtoVersionable> T convertUp(CustomerDtoVersionable input, Class<T> target) {

        CustomerDtoVersionable current = input;
        CustomerDtoVersionable prev = null;
        while(prev != current){
            if(current.getClass().isInstance(target)){
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

    public static <T extends CustomerDtoVersionable> T convertDown(CustomerDtoVersionable input, Class<T> target) {

        CustomerDtoVersionable current = input;
        CustomerDtoVersionable prev = null;
        while(prev != current){
            if(current.getClass().isInstance(target)){
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

}
