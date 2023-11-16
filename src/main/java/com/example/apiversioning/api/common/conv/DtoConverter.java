package com.example.apiversioning.api.common.conv;

public class DtoConverter {
    private Adapter<?,?>[] adapters;

    public DtoConverter(Adapter<?,?>... adapters) {
        this.adapters = adapters;
    }

    private int findAdapter(Object input){
        for(int i = 0; i < adapters.length; i++){
            if(adapters[i].getLowerVersionClass().isInstance(input)){
                return i;
            }
        }
        throw new IllegalArgumentException("Object is not in the adapterlist");
    }
   public <T> T convertUp(Object input, Class<T> outputClass) {
        Object currentObj = input;

        for (int i = findAdapter(input); i < adapters.length; i++) {
            currentObj = adapters[i].convertForward(currentObj);
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
            currentObj = adapters[i].convertBackward(currentObj);
            if (currentObj.getClass() == outputClass) {
                //noinspection unchecked
                return (T) currentObj;
            }
        }

        throw new IllegalArgumentException("Conversion not possible");
    }
}
