package com.dberna2.mapper;

import com.dberna2.dto.CarDTO;
import com.dberna2.model.Car;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    CarDTO mapCarToCarDto(Car car);

    @InheritInverseConfiguration
    List<CarDTO> mapCarToCarDtoList(List<Car> carList);

}
