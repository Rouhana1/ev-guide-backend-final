package com.example.cms.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VehicleResponseDto {
    private String modelCode;
    private String name;
    private String description;
    private Integer range;
    private Double price;
    private Integer seats;
    private Double batteryCapacity;
    private String manufacturerName;
    private Integer horsepower;
    private String type;

}
