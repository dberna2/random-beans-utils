package com.dberna2.randomizer.car;

import com.dberna2.data.car.CarData;
import com.dberna2.model.Engine;
import com.dberna2.enumerator.EngineTypeEnum;
import io.github.benas.randombeans.api.Randomizer;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class CarEngineRandomizer extends CarData implements Randomizer<Engine> {

    @Override
    public Engine getRandomValue() {
        return getEngine();
    }
}
