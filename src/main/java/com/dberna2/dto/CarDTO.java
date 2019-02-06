package com.dberna2.dto;

public class CarDTO {

    private String color;
    private String brand;
    private EngineDTO engine;

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

    public EngineDTO getEngine() {
        return engine;
    }

    public void setEngine(EngineDTO engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "CarDTO{" +
                "color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                ", engine=" + engine +
                '}';
    }
}
