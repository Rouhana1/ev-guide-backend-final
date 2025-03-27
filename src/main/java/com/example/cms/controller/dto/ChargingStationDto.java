package com.example.cms.controller.dto;

import lombok.Data;

@Data
public class ChargingStationDto {
    private Long id;
    private String location;
    private String provider;
    private Integer capacity;
}
