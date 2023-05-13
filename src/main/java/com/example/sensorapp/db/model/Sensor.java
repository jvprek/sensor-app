package com.example.sensorapp.db.model;

import com.example.sensorapp.common.model.SensorType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="sensors")
@Data
public class Sensor {

    @Id
    @Column(name = "sensor_name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "sensor_type")
    private SensorType type;


}
