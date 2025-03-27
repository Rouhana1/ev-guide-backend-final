package com.example.cms.controller.exceptions;

public class ManufacturerNotFoundException extends RuntimeException {
    public ManufacturerNotFoundException(String id) {
        super("Could not find manufacturer with id: " + id);
    }
}