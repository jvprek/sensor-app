use sensors;
INSERT INTO sensors.sensors (sensor_name, sensor_type) VALUES
 ('DUB1_HUM', 'HUMIDITY'),
 ('DUB1_TMP', 'TEMPERATURE'),
 ('DUB1_WINDIR', 'WIND_DIRECTION'),
 ('DUB1_WINSP', 'WIND_SPEED'),
 ('DUB2_HUM', 'HUMIDITY'),
 ('DUB2_TMP', 'TEMPERATURE'),
 ('DUB2_WINDIR', 'WIND_DIRECTION'),
 ('DUB2_WINSP', 'WIND_SPEED'),
 ('CORK_HUM', 'HUMIDITY'),
 ('CORK_TMP', 'TEMPERATURE'),
 ('CORK_WINDIR', 'WIND_DIRECTION'),
 ('CORK_WINSP', 'WIND_SPEED');


INSERT INTO sensors.sensor_data (sample_tm, sample_value, sensor_name) VALUES( now(), cast(FLOOR(RAND() * 100) as char), 'DUB1_HUM');                                                               ,
INSERT INTO sensors.sensor_data (sample_tm, sample_value, sensor_name) VALUES ( now(), cast(-10 + FLOOR(RAND() * 40) as char), 'DUB1_TMP');
INSERT INTO sensors.sensor_data (sample_tm, sample_value, sensor_name) VALUES( now(), cast(FLOOR(RAND() * 360) as char), 'DUB1_WINDIR');
INSERT INTO sensors.sensor_data (sample_tm, sample_value, sensor_name) VALUES( now(), cast(FLOOR(RAND() * 100) as char), 'DUB1_WINSP');

INSERT INTO sensors.sensor_data (sample_tm, sample_value, sensor_name) VALUES( now(), cast(FLOOR(RAND() * 100) as char), 'DUB2_HUM');                                                               ,
INSERT INTO sensors.sensor_data (sample_tm, sample_value, sensor_name) VALUES ( now(), cast(-10 + FLOOR(RAND() * 40) as char), 'DUB2_TMP');
INSERT INTO sensors.sensor_data (sample_tm, sample_value, sensor_name) VALUES( now(), cast(FLOOR(RAND() * 360) as char), 'DUB2_WINDIR');
INSERT INTO sensors.sensor_data (sample_tm, sample_value, sensor_name) VALUES( now(), cast(FLOOR(RAND() * 100) as char), 'DUB2_WINSP');

INSERT INTO sensors.sensor_data (sample_tm, sample_value, sensor_name) VALUES( now(), cast(FLOOR(RAND() * 100) as char), 'CORK_HUM');                                                               ,
INSERT INTO sensors.sensor_data (sample_tm, sample_value, sensor_name) VALUES ( now(), cast(-10 + FLOOR(RAND() * 40) as char), 'CORK_TMP');
INSERT INTO sensors.sensor_data (sample_tm, sample_value, sensor_name) VALUES( now(), cast(FLOOR(RAND() * 360) as char), 'CORK_WINDIR');
INSERT INTO sensors.sensor_data (sample_tm, sample_value, sensor_name) VALUES( now(), cast(FLOOR(RAND() * 100) as char), 'CORK_WINSP');
