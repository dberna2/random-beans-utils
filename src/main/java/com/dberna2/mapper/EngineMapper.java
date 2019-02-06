package com.dberna2.mapper;

import com.dberna2.dto.EngineDTO;
import com.dberna2.model.Engine;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EngineMapper {

    EngineMapper INSTANCE = Mappers.getMapper(EngineMapper.class);

    EngineDTO mapEngineToEngineDto(Engine engine);

    @InheritInverseConfiguration
    List<EngineDTO> mapEngineToEngineDtoList(List<Engine> engineList);

}
