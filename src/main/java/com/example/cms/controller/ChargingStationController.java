package com.example.cms.controller;

import com.example.cms.controller.dto.ChargingStationDto;
import com.example.cms.model.entity.ChargingStation;
import com.example.cms.model.repository.ChargingStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/charging-stations")
public class ChargingStationController {

    @Autowired
    private ChargingStationRepository repository;

    @GetMapping
    public List<ChargingStation> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ChargingStation getById(@PathVariable Long id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping
    public ChargingStation create(@RequestBody ChargingStationDto dto) {
        ChargingStation cs = new ChargingStation();
        cs.setLocation(dto.getLocation());
        cs.setProvider(dto.getProvider());
        cs.setCapacity(dto.getCapacity());
        return repository.save(cs);
    }

    @PutMapping("/{id}")
    public ChargingStation update(@PathVariable Long id, @RequestBody ChargingStationDto dto) {
        ChargingStation cs = repository.findById(id).orElseThrow();
        cs.setLocation(dto.getLocation());
        cs.setProvider(dto.getProvider());
        cs.setCapacity(dto.getCapacity());
        return repository.save(cs);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
