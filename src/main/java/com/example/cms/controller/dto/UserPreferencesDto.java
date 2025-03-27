package com.example.cms.controller.dto;

import lombok.Data;

@Data
public class UserPreferencesDto {
    private Long id;
    private Double budget;
    private Integer seats;
    private Integer minRange;
    private String preferredManufacturerId;
    private String type;
    private Integer minHorsepower;
    private String fullName;

}
