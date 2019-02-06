package com.dberna2.data;

import com.dberna2.util.JSONUtils;

import java.util.List;
import java.util.Random;

public abstract class ConfigurationData<T> {

    private static final Random RANDOM = new Random();

    protected abstract Class<T> getClassReference();

    protected List<T> buildData(){
        return JSONUtils.getListByClass(getClassReference());
    }

    protected T getRandomObject(){
        final List<T> resultData = buildData();
        return resultData.get(RANDOM.nextInt(resultData.size()));
    }
}
