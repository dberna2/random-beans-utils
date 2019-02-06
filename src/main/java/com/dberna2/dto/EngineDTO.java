package com.dberna2.dto;

import com.dberna2.enumerator.EngineTypeEnum;

public class EngineDTO{

    private String id;
    private EngineTypeEnum type;
    private Integer horsePower;
    private String brand;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EngineTypeEnum getType() {
        return type;
    }

    public void setType(EngineTypeEnum type) {
        this.type = type;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "EngineDTO{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", horsePower=" + horsePower +
                ", brand='" + brand + '\'' +
                '}';
    }
}
