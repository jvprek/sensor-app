package com.example.sensorapp.rest;

import com.example.sensorapp.common.model.SensorType;
import com.example.sensorapp.db.repository.SensorRepository;
import com.example.sensorapp.rest.model.SensorDTO;
import com.example.sensorapp.service.SensorMapper;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sensors/admin")
public class AdminAPI {

    private final SensorRepository repository;
    private final SensorMapper mapper;

    public AdminAPI(SensorRepository repository, SensorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    // Endpoint to retrieve sensor by name
    @GetMapping("/{name}")
    public ResponseEntity<?> getSensorByName(@NotNull @PathVariable String name) {
        var e = repository.findById(name);
        if (e.isPresent()) {
            return ResponseEntity.ok(mapper.entityToDto(e.get()));
        }
        return ResponseEntity.notFound().build();
    }
    // Endpoint to list all sensors with a given type
    @GetMapping("/type/{type}")
    public List<SensorDTO> getSensorsByType(@NotNull @PathVariable String type) {
        var typeValue = SensorType.valueOf(type);
        var entityList =  repository.findSensorByType(typeValue);
        var dtoList = entityList.stream().map(mapper::entityToDto).collect(Collectors.toList());
        return dtoList;
    }

    // Endpoint to list all sensors
    @GetMapping("/all")
    public List<SensorDTO> getAllSensors() {
        var entityList =  repository.findAll();
        var dtoList = entityList.stream().map(mapper::entityToDto).collect(Collectors.toList());
        return dtoList;
    }

    // Endpoint to create a new sensor
    @PostMapping
    public ResponseEntity<?> createSensor(@NotNull  @RequestBody SensorDTO dto) {
        var e = mapper.dtoToEntity(dto);
        repository.save(e);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
