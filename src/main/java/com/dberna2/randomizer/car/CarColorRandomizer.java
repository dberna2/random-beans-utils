package com.dberna2.randomizer.car;


import com.dberna2.data.car.CarData;
import io.github.benas.randombeans.api.Randomizer;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CarColorRandomizer extends CarData implements Randomizer<String> {


    @Override
    public String getRandomValue() {
        return getColor();
    }
}
