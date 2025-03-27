package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user_preferences")
public class UserPreferences {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Double budget;

    @NotNull
    private Integer seats;

    @NotNull
    @Column(name = "min_range")
    private Integer minRange;

    @Column(name = "preferred_manufacturer_id")
    private String preferredManufacturerId;

    @Column(name = "type")
    private String type;

    @Column(name = "min_horsepower")
    private Integer minHorsepower;

    @Column(name = "full_name")
    private String fullName;

}
