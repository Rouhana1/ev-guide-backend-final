package com.example.cms.controller;

import com.example.cms.controller.dto.UserPreferencesDto;
import com.example.cms.model.entity.UserPreferences;
import com.example.cms.model.entity.Vehicle;
import com.example.cms.model.repository.UserPreferencesRepository;
import com.example.cms.model.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin
@RestController
@RequestMapping("/preferences")
public class UserPreferencesController {

    @Autowired
    private UserPreferencesRepository preferencesRepo;

    @Autowired
    private VehicleRepository vehicleRepo;

    @GetMapping
    public List<UserPreferences> getAllPreferences() {
        return preferencesRepo.findAll();
    }

    @PostMapping
    public List<Vehicle> submitPreferences(@RequestBody UserPreferencesDto dto) {
        UserPreferences prefs = new UserPreferences();
        prefs.setFullName(dto.getFullName());
        prefs.setBudget(dto.getBudget());
        prefs.setSeats(dto.getSeats());
        prefs.setMinRange(dto.getMinRange());
        prefs.setPreferredManufacturerId(dto.getPreferredManufacturerId());
        prefs.setMinHorsepower(dto.getMinHorsepower());
        prefs.setType(dto.getType());
        preferencesRepo.save(prefs);

        return vehicleRepo.findAll().stream().filter(vehicle ->
                vehicle.getPrice() <= dto.getBudget() &&
                        vehicle.getSeats() >= dto.getSeats() &&
                        vehicle.getRange() >= dto.getMinRange() &&
                        (vehicle.getHorsepower() == null || prefs.getMinHorsepower() == null || vehicle.getHorsepower() >= prefs.getMinHorsepower()) &&
                        (prefs.getType() == null || prefs.getType().isEmpty() || prefs.getType().equalsIgnoreCase(vehicle.getType())) &&
                        (dto.getPreferredManufacturerId() == null || dto.getPreferredManufacturerId().isEmpty() ||
                                (vehicle.getManufacturer() != null &&
                                        dto.getPreferredManufacturerId().equals(vehicle.getManufacturer().getId())))
        ).collect(Collectors.toList());
    }
}
