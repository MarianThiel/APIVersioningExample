package com.example.apiversioning.api.common.versioning;

/**
 * Problematic at runtime, requires to chain all Versionable objects together.
 * Also cyclic chaining is possible as well as none reachable versions
 */
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

        throw new IllegalStateException(("target class %s is not reachable").formatted(target));
    }

    public B toBaseDto(C inputDto){
        C highestVersionDto = convertUp(inputDto, highestVersion);
        if( highestVersionDto instanceof HighestVersionable<?>){
            @SuppressWarnings("unchecked") HighestVersionable<B> versionDto = (HighestVersionable<B>) highestVersionDto;
            return versionDto.toBaseDto();
        }

        throw new IllegalStateException("Could not convert to highest version");
    }

    public <T extends DtoVersionable<C>> T fromBaseDtoToSpecificVersion(B base, Class<T> targetVersionClass){
        HighestVersionable<B> highestVersionable = base.toHighestDto();
        @SuppressWarnings("unchecked") C c = (C) highestVersionable;
        return convertDown(c, targetVersionClass);
    }

}
