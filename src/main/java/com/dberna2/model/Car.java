package com.dberna2.model;

import com.dberna2.randomizer.car.CarBrandRandomizer;
import com.dberna2.randomizer.car.CarColorRandomizer;
import com.dberna2.randomizer.car.CarEngineRandomizer;
import io.github.benas.randombeans.annotation.Randomizer;

public class Car {

    @Randomizer(CarColorRandomizer.class)
    private String color;
    @Randomizer(CarBrandRandomizer.class)
    private String brand;
    @Randomizer(CarEngineRandomizer.class)
    private Engine engine;

    public Car() {
    }

    public Car(String color, String brand, Engine engine) {
        this.color = color;
        this.brand = brand;
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
