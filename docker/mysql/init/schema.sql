create database sensors;
use sensors;

create table sensors
(
    sensor_name varchar(255) not null primary key,
    sensor_type varchar(20)  not null
);

create table sensor_data
(
    sample_id        bigint       auto_increment primary key,
    sample_tm        datetime(6)  not null,
    sample_value     varchar(20)  not null,
    sensor_name      varchar(255) not null,
    constraint sensor_sensor_data_fk
        foreign key (sensor_name) references sensors.sensors (sensor_name)
);


CREATE USER 'sensors'@'%' IDENTIFIED BY 'sensors';
GRANT ALL PRIVILEGES ON sensors.* TO 'sensors'@'%';

