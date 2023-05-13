package com.example.sensorapp.rest.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SensorDataDTO {

    @NotNull
    private String name;
    @PastOrPresent
    private LocalDateTime time;
    @NotNull
    private String value;
}
