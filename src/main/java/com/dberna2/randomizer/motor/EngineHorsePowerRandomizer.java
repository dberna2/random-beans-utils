package com.dberna2.randomizer.motor;


import com.dberna2.data.engine.EngineData;
import io.github.benas.randombeans.api.Randomizer;

public class EngineHorsePowerRandomizer extends EngineData implements Randomizer<Integer> {

    @Override
    public Integer getRandomValue() {
        return getHorsePower();
    }
}
