package com.dberna2.model;

import com.dberna2.enumerator.EngineTypeEnum;

public class Engine {

    private String id;
    private EngineTypeEnum type;
    private Integer horsePower;
    private String brand;

    public Engine() {
    }

    public Engine(String id, EngineTypeEnum type, Integer horsePower, String brand) {
        this.id = id;
        this.type = type;
        this.horsePower = horsePower;
        this.brand = brand;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Engine engine = (Engine) o;

        if (id != null ? !id.equals(engine.id) : engine.id != null) return false;
        if (type != engine.type) return false;
        if (horsePower != null ? !horsePower.equals(engine.horsePower) : engine.horsePower != null) return false;
        return brand != null ? brand.equals(engine.brand) : engine.brand == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (horsePower != null ? horsePower.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        return result;
    }
}
