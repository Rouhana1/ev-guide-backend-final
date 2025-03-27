package com.example.cms.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "manufacturers")
public class Manufacturer {

    @Id
    @Column(name = "id")
    private String id;

    @NotEmpty
    @Column(name = "name")
    private String name;

    @NotEmpty
    @Column(name = "country")
    private String country;

    @Column(name = "website")
    private String website;

    @OneToMany(mappedBy = "manufacturer")
    @JsonManagedReference
    private List<Vehicle> vehicles = new ArrayList<>();

    public Manufacturer(String id, String name, String country, String website) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.website = website;
    }
}