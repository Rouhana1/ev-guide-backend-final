package com.example.cms.controller;

import com.example.cms.controller.dto.VehicleDto;
import com.example.cms.controller.dto.VehicleResponseDto;
import com.example.cms.controller.exceptions.ManufacturerNotFoundException;
import com.example.cms.controller.exceptions.VehicleNotFoundException;
import com.example.cms.model.entity.Manufacturer;
import com.example.cms.model.entity.Vehicle;
import com.example.cms.model.repository.ManufacturerRepository;
import com.example.cms.model.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;

import java.util.List;

@CrossOrigin
@RestController
public class VehicleController {

    @Autowired
    private final VehicleRepository repository;

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    public VehicleController(VehicleRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/vehicles")
    public List<VehicleResponseDto> retrieveAllVehicles() {
        return repository.findAll().stream().map(vehicle ->
                new VehicleResponseDto(
                        vehicle.getModelCode(),
                        vehicle.getName(),
                        vehicle.getDescription(),
                        vehicle.getRange(),
                        vehicle.getPrice(),
                        vehicle.getSeats(),
                        vehicle.getBatteryCapacity(),
                        vehicle.getManufacturer() != null ? vehicle.getManufacturer().getName() : "Unknown",
                        vehicle.getHorsepower(),
                        vehicle.getType()

                )
        ).collect(Collectors.toList());
    }


    @PostMapping("/vehicles")
    Vehicle createVehicle(@RequestBody VehicleDto vehicleDto) {
        Vehicle newVehicle = new Vehicle();
        newVehicle.setModelCode(vehicleDto.getModelCode());
        newVehicle.setName(vehicleDto.getName());
        newVehicle.setDescription(vehicleDto.getDescription());
        newVehicle.setRange(vehicleDto.getRange());
        newVehicle.setPrice(vehicleDto.getPrice());
        newVehicle.setSeats(vehicleDto.getSeats());
        newVehicle.setBatteryCapacity(vehicleDto.getBatteryCapacity());
        newVehicle.setHorsepower(vehicleDto.getHorsepower());
        newVehicle.setType(vehicleDto.getType());

        Manufacturer manufacturer = manufacturerRepository.findById(vehicleDto.getManufacturerId())
                .orElseThrow(() -> new ManufacturerNotFoundException(vehicleDto.getManufacturerId()));
        newVehicle.setManufacturer(manufacturer);

        return repository.save(newVehicle);
    }

    @GetMapping("/vehicles/{modelCode}")
    Vehicle retrieveVehicle(@PathVariable("modelCode") String modelCode) {
        return repository.findById(modelCode)
                .orElseThrow(() -> new VehicleNotFoundException(modelCode));
    }

    @PutMapping("/vehicles/{modelCode}")
    Vehicle updateVehicle(@RequestBody VehicleDto vehicleDto, @PathVariable("modelCode") String modelCode) {
        return repository.findById(modelCode)
                .map(vehicle -> {
                    vehicle.setName(vehicleDto.getName());
                    vehicle.setDescription(vehicleDto.getDescription());
                    vehicle.setRange(vehicleDto.getRange());
                    vehicle.setPrice(vehicleDto.getPrice());
                    vehicle.setSeats(vehicleDto.getSeats());
                    vehicle.setBatteryCapacity(vehicleDto.getBatteryCapacity());
                    vehicle.setHorsepower(vehicleDto.getHorsepower());
                    vehicle.setType(vehicleDto.getType());


                    Manufacturer manufacturer = manufacturerRepository.findById(vehicleDto.getManufacturerId())
                            .orElseThrow(() -> new ManufacturerNotFoundException(vehicleDto.getManufacturerId()));
                    vehicle.setManufacturer(manufacturer);

                    return repository.save(vehicle);
                })
                .orElseGet(() -> {
                    Vehicle newVehicle = new Vehicle();
                    newVehicle.setModelCode(modelCode);
                    newVehicle.setName(vehicleDto.getName());
                    newVehicle.setDescription(vehicleDto.getDescription());
                    newVehicle.setRange(vehicleDto.getRange());
                    newVehicle.setPrice(vehicleDto.getPrice());
                    newVehicle.setSeats(vehicleDto.getSeats());
                    newVehicle.setBatteryCapacity(vehicleDto.getBatteryCapacity());
                    newVehicle.setHorsepower(vehicleDto.getHorsepower());
                    newVehicle.setType(vehicleDto.getType());

                    Manufacturer manufacturer = manufacturerRepository.findById(vehicleDto.getManufacturerId())
                            .orElseThrow(() -> new ManufacturerNotFoundException(vehicleDto.getManufacturerId()));
                    newVehicle.setManufacturer(manufacturer);

                    return repository.save(newVehicle);
                });
    }

    @DeleteMapping("/vehicles/{modelCode}")
    void deleteVehicle(@PathVariable("modelCode") String modelCode) {
        repository.deleteById(modelCode);
    }
}