package com.example.sensorapp.db.repository;

import com.example.sensorapp.common.model.SensorType;
import com.example.sensorapp.db.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, String> {

    List<Sensor> findSensorByType(SensorType type);
}
