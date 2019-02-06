package com.dberna2.randomizer.motor;


import com.dberna2.data.engine.EngineData;
import io.github.benas.randombeans.api.Randomizer;

public class EngineBrandRandomizer extends EngineData implements Randomizer<String> {


    @Override
    public String getRandomValue() {
        return getBrand();
    }
}
