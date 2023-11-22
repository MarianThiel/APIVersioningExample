package com.example.apiversioning.api.common.versioning;

public interface VersioningBase<B, H> {
    H fromBaseToHighestDto(B base);
    B toBaseFromHighestDto(H highestVersion);


}
