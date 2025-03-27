package com.example.cms.controller.dto;

import lombok.Data;

@Data
public class VehicleDto {
    private String modelCode;
    private String name;
    private String description;
    private Integer range;
    private Double price;
    private Integer seats;
    private Double batteryCapacity;
    private String manufacturerId;
    private Integer horsepower;
    private String type;


}