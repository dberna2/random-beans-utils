package com.dberna2.data.car;

import com.dberna2.data.ConfigurationData;
import com.dberna2.model.Car;
import com.dberna2.model.Engine;

public class CarData extends ConfigurationData<Car> {

    private static Car car = null;

    protected CarData(){
        car = getRandomObject();
    }

    protected String getColor(){
        return car.getColor();
    }

    protected String getBrand(){
        return car.getBrand();
    }

    protected Engine getEngine(){
        return car.getEngine();
    }

    @Override
    protected Class<Car> getClassReference() {
        return Car.class;
    }
}
