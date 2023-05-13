package com.example.sensorapp.rest.model;

import com.example.sensorapp.common.model.SensorType;
import lombok.Data;

@Data
public class SensorDTO {

    private String name;

    private SensorType type;
}
