package com.example.sensorapp.db.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="sensor_data")
public class SensorData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sample_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sensor_name")
    private Sensor sensor;

    @Column(name = "sample_tm")
    private LocalDateTime time;

    @Column(name = "sample_value")
    private String value;
}
