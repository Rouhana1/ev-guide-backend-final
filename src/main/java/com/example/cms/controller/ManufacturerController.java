package com.example.cms.controller;

import com.example.cms.controller.dto.ManufacturerDto;
import com.example.cms.controller.exceptions.ManufacturerNotFoundException;
import com.example.cms.model.entity.Manufacturer;
import com.example.cms.model.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ManufacturerController {

    @Autowired
    private final ManufacturerRepository repository;

    public ManufacturerController(ManufacturerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/manufacturers")
    List<Manufacturer> retrieveAllManufacturers() {
        return repository.findAll();
    }

    @PostMapping("/manufacturers")
    Manufacturer createManufacturer(@RequestBody ManufacturerDto manufacturerDto) {
        Manufacturer newManufacturer = new Manufacturer();
        newManufacturer.setId(manufacturerDto.getId());
        newManufacturer.setName(manufacturerDto.getName());
        newManufacturer.setCountry(manufacturerDto.getCountry());
        newManufacturer.setWebsite(manufacturerDto.getWebsite());

        return repository.save(newManufacturer);
    }

    @GetMapping("/manufacturers/{id}")
    Manufacturer retrieveManufacturer(@PathVariable("id") String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ManufacturerNotFoundException(id));
    }

    @PutMapping("/manufacturers/{id}")
    Manufacturer updateManufacturer(@RequestBody ManufacturerDto manufacturerDto, @PathVariable("id") String id) {
        return repository.findById(id)
                .map(manufacturer -> {
                    manufacturer.setName(manufacturerDto.getName());
                    manufacturer.setCountry(manufacturerDto.getCountry());
                    manufacturer.setWebsite(manufacturerDto.getWebsite());
                    return repository.save(manufacturer);
                })
                .orElseGet(() -> {
                    Manufacturer newManufacturer = new Manufacturer();
                    newManufacturer.setId(id);
                    newManufacturer.setName(manufacturerDto.getName());
                    newManufacturer.setCountry(manufacturerDto.getCountry());
                    newManufacturer.setWebsite(manufacturerDto.getWebsite());
                    return repository.save(newManufacturer);
                });
    }

    @DeleteMapping("/manufacturers/{id}")
    void deleteManufacturer(@PathVariable("id") String id) {
        repository.deleteById(id);
    }
}