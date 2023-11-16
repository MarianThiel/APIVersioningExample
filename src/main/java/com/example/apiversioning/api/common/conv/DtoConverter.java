package com.example.apiversioning.api.common.conv;

public class DtoConverter {
    private ObjectTransformer<?,?>[] objectTransformers;

    public DtoConverter(ObjectTransformer<?,?>... objectTransformers) {
        this.objectTransformers = objectTransformers;
    }

    private int findAdapter(Object input){
        for(int i = 0; i < objectTransformers.length; i++){
            if(objectTransformers[i].getLowerVersionClass().isInstance(input)){
                return i;
            }
        }
        throw new IllegalArgumentException("Object is not in the adapterlist");
    }
   public <T> T convertUp(Object input, Class<T> outputClass) {
        Object currentObj = input;

        for (int i = findAdapter(input); i < objectTransformers.length; i++) {
            currentObj = objectTransformers[i].convertForward(currentObj);
            if (currentObj.getClass() == outputClass) {
                //noinspection unchecked
                return (T) currentObj;
            }
        }

        throw new IllegalArgumentException("Conversion not possible");
    }
    public <T> T convertDown(Object input, Class<T> outputClass) {
        Object currentObj = input;

        for (int i = findAdapter(input); i >= 0 ; i--) {
            currentObj = objectTransformers[i].convertBackward(currentObj);
            if (currentObj.getClass() == outputClass) {
                //noinspection unchecked
                return (T) currentObj;
            }
        }

        throw new IllegalArgumentException("Conversion not possible");
    }
}
