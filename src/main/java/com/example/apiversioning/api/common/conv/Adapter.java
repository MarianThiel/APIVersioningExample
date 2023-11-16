package com.example.apiversioning.api.common.conv;

public abstract class Adapter<V1, V2> {

    private Class<V1> lowerVersionClass;
    private Class<V2> higherVersionClass;

    protected abstract V2 convertForward(Object input);

    protected abstract V1 convertBackward(Object input); // T extends <Interface>

    public Adapter(Class<V1> lowerVersionClass, Class<V2> higherVersionClass) {
        this.lowerVersionClass = lowerVersionClass;
        this.higherVersionClass = higherVersionClass;
    }

    public Class<V1> getLowerVersionClass() {
        return lowerVersionClass;
    }

    public Class<V2> getHigherVersionClass() {
        return higherVersionClass;
    }
}