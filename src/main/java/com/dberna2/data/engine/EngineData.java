package com.dberna2.data.engine;

import com.dberna2.data.ConfigurationData;
import com.dberna2.enumerator.EngineTypeEnum;
import com.dberna2.model.Engine;

public class EngineData extends ConfigurationData<Engine> {

    private static Engine engine = null;

    protected EngineData(){
        engine = getRandomObject();
    }

    protected String getId(){
        return engine.getId();
    }

    protected EngineTypeEnum getType(){
        return engine.getType();
    }

    protected Integer getHorsePower(){
        return engine.getHorsePower();
    }

    protected String getBrand(){
        return engine.getBrand();
    }

    @Override
    protected Class<Engine> getClassReference() {
        return Engine.class;
    }
}
