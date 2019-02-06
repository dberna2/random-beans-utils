package com.dberna2;

import com.dberna2.config.EnhancedRandomConfig;

import java.util.List;
import java.util.stream.Collectors;

public class TestSupport{

    public <T> T getObjectByClassReference(Class<T>  classToGenerate, String... excludeFields){
        return EnhancedRandomConfig.buildEnhancedRandomConfiguration().nextObject(classToGenerate, excludeFields);
    }

    public  <T> List<T> getListByClassReference(Class<T>  classToGenerate, int elementsTogenerate, String... excludeFields){
        return EnhancedRandomConfig.buildEnhancedRandomConfiguration().objects(classToGenerate, elementsTogenerate, excludeFields)
                .collect(Collectors.toList());
    }
}
