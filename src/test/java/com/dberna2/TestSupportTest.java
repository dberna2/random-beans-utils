package com.dberna2;

import com.dberna2.dto.CarDTO;
import com.dberna2.dto.EngineDTO;
import com.dberna2.mapper.CarMapper;
import com.dberna2.mapper.EngineMapper;
import com.dberna2.model.Car;
import com.dberna2.model.Engine;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestSupportTest {

    private TestSupport testSupport = new TestSupport();

    @Test
    public void getObjectByClassReferenceWhitAnnotationsTest() throws Exception {

        Car car = testSupport.getObjectByClassReference(Car.class);

        CarDTO carDto = CarMapper.INSTANCE.mapCarToCarDto(car);

        assertEquals(car.getColor(), carDto.getColor());
        assertEquals(car.getBrand(), carDto.getBrand());
        assertNotNull(car.getEngine());
        assertEquals(car.getEngine().getId(), carDto.getEngine().getId());
        assertEquals(car.getEngine().getBrand(), carDto.getEngine().getBrand());
        assertEquals(car.getEngine().getHorsePower(), carDto.getEngine().getHorsePower());
        assertEquals(car.getEngine().getType(), carDto.getEngine().getType());
    }

    @Test
    public void getListByClassReferenceWhitAnnotationsTest() throws Exception {

        int elementsToGenerate = 4;

        List<Car> carList = testSupport.getListByClassReference(Car.class, elementsToGenerate);

        List<CarDTO> carDTOList = CarMapper.INSTANCE.mapCarToCarDtoList(carList);

        for (int i = 0; i < carList.size(); i ++) {
            assertEquals(carList.size(), carDTOList.size());
            assertEquals(carList.get(i).getColor(), carDTOList.get(i).getColor());
            assertEquals(carList.get(i).getBrand(), carDTOList.get(i).getBrand());
            assertNotNull(carList.get(i).getEngine());
            assertEquals(carList.get(i).getEngine().getId(), carDTOList.get(i).getEngine().getId());
            assertEquals(carList.get(i).getEngine().getBrand(), carDTOList.get(i).getEngine().getBrand());
            assertEquals(carList.get(i).getEngine().getHorsePower(), carDTOList.get(i).getEngine().getHorsePower());
            assertEquals(carList.get(i).getEngine().getType(), carDTOList.get(i).getEngine().getType());
        }
    }

    @Test
    public void getObjectByClassReferenceWhitConfigurationTest() throws Exception {

        Engine engine = testSupport.getObjectByClassReference(Engine.class);

        EngineDTO engineDTO = EngineMapper.INSTANCE.mapEngineToEngineDto(engine);

        assertEquals(engine.getId(), engineDTO.getId());
        assertEquals(engine.getBrand(), engineDTO.getBrand());
        assertEquals(engine.getHorsePower(), engineDTO.getHorsePower());
        assertEquals(engine.getType(), engineDTO.getType());
    }

    @Test
    public void getListByClassReferenceWhitConfigurationTest() throws Exception {

        int elementsToGenerate = 3;

        List<Engine> engineList = testSupport.getListByClassReference(Engine.class, elementsToGenerate);

        List<EngineDTO> engineDTOList = EngineMapper.INSTANCE.mapEngineToEngineDtoList(engineList);

        for (int i = 0; i < engineList.size(); i ++) {
            assertEquals(engineList.size(), engineDTOList.size());
            assertEquals(engineList.get(i).getId(), engineDTOList.get(i).getId());
            assertEquals(engineList.get(i).getBrand(), engineDTOList.get(i).getBrand());
            assertEquals(engineList.get(i).getHorsePower(), engineDTOList.get(i).getHorsePower());
            assertEquals(engineList.get(i).getType(), engineDTOList.get(i).getType());
        }
    }
}