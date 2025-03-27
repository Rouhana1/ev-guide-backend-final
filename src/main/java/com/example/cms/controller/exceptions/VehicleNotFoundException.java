package com.example.cms.controller.exceptions;

public class VehicleNotFoundException extends RuntimeException {
    public VehicleNotFoundException(String modelCode) {
        super("Could not find vehicle with model code: " + modelCode);
    }
}