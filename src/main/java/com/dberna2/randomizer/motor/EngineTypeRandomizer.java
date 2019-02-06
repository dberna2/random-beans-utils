package com.dberna2.randomizer.motor;


import com.dberna2.data.engine.EngineData;
import com.dberna2.enumerator.EngineTypeEnum;
import io.github.benas.randombeans.api.Randomizer;

public class EngineTypeRandomizer extends EngineData implements Randomizer<EngineTypeEnum> {

    @Override
    public EngineTypeEnum getRandomValue() {
        return getType();
    }
}
