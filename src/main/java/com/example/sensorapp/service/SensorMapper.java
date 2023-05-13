package com.example.sensorapp.service;

import com.example.sensorapp.db.model.Sensor;
import com.example.sensorapp.rest.model.SensorDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SensorMapper {
    SensorDTO entityToDto(Sensor entity);

    List<SensorDTO> entityListToDtoList(List<Sensor> entity);
    Sensor dtoToEntity(SensorDTO entity);
    List<Sensor> dtoListToEntityList(List<SensorDTO> entity);

}

