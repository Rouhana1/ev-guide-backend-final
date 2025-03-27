package com.example.cms.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @Column(name = "model_code")
    private String modelCode;

    @NotEmpty
    @Column(name = "name")
    private String name;

    @NotEmpty
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "range")
    private Integer range; // in miles

    @NotNull
    @Column(name = "price")
    private Double price; // base price

    @NotNull
    @Column(name = "seats")
    private Integer seats;

    @NotNull
    @Column(name = "battery_capacity")
    private Double batteryCapacity; // in kWh

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    @JsonIgnoreProperties({"vehicles"})
    private Manufacturer manufacturer;

    @NotNull
    @Column(name = "horsepower")
    private Integer horsepower;

    @NotEmpty
    @Column(name = "type") // e.g., SUV, SEDAN, COUPE
    private String type;




    public Vehicle(String modelCode, String name, String description, Integer range,
                   Double price, Integer seats, Double batteryCapacity, Manufacturer manufacturer) {
        this.modelCode = modelCode;
        this.name = name;
        this.description = description;
        this.range = range;
        this.price = price;
        this.seats = seats;
        this.batteryCapacity = batteryCapacity;
        this.manufacturer = manufacturer;
    }
}