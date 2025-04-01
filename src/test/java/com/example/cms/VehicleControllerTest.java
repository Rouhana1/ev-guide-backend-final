package com.example.cms;

import com.example.cms.model.entity.Manufacturer;
import com.example.cms.model.entity.Vehicle;
import com.example.cms.model.repository.ManufacturerRepository;
import com.example.cms.model.repository.VehicleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class VehicleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Test
    public void createVehicle() throws Exception {
        Manufacturer m = new Manufacturer();
        m.setId("mfg-v1");
        m.setName("SpeedCo");
        m.setCountry("Fastland");
        m.setWebsite("https://speedco.com");
        manufacturerRepository.save(m);

        ObjectNode dto = objectMapper.createObjectNode();
        dto.put("modelCode", "model-v1");
        dto.put("name", "Lightning EV");
        dto.put("description", "A fast electric vehicle");
        dto.put("range", 450);
        dto.put("price", 55000.0);
        dto.put("seats", 5);
        dto.put("batteryCapacity", 85.0);
        dto.put("manufacturerId", "mfg-v1");
        dto.put("horsepower", 300);
        dto.put("type", "Sedan");

        MockHttpServletResponse response = mockMvc.perform(
                post("/vehicles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dto.toString())
        ).andReturn().getResponse();

        assertEquals(200, response.getStatus());
        assertTrue(vehicleRepository.findById("model-v1").isPresent());
    }

    @Test
    public void getVehicleByModelCode() throws Exception {
        Manufacturer m = new Manufacturer();
        m.setId("mfg-get");
        m.setName("AutoGen");
        m.setCountry("Getland");
        m.setWebsite("https://autogen.com");
        manufacturerRepository.save(m);

        Vehicle v = new Vehicle();
        v.setModelCode("lookup-v1");
        v.setName("Lookup Car");
        v.setDescription("A test car");
        v.setPrice(30000.0);
        v.setSeats(4);
        v.setRange(400);
        v.setHorsepower(180);
        v.setBatteryCapacity(75.0);
        v.setType("Hatchback");
        v.setManufacturer(m);
        vehicleRepository.save(v);

        MockHttpServletResponse response = mockMvc.perform(
                get("/vehicles/lookup-v1")
        ).andReturn().getResponse();

        assertEquals(200, response.getStatus());
        assertTrue(response.getContentAsString().contains("Lookup Car"));
    }

    @Test
    public void getAllVehicles() throws Exception {
        Vehicle v = new Vehicle();
        v.setModelCode("all-v1");
        v.setName("Showroom Star");
        v.setDescription("A showroom car");
        v.setPrice(47000.0);
        v.setSeats(5);
        v.setRange(480);
        v.setBatteryCapacity(80.0);
        v.setHorsepower(220);
        v.setType("SUV");
        vehicleRepository.save(v);

        MockHttpServletResponse response = mockMvc.perform(
                get("/vehicles")
        ).andReturn().getResponse();

        assertEquals(200, response.getStatus());
        assertTrue(response.getContentAsString().contains("Showroom Star"));
    }

    @Test
    public void updateVehicle() throws Exception {
        Manufacturer m = new Manufacturer();
        m.setId("mfg-update");
        m.setName("UpdateCo");
        m.setCountry("UpdateLand");
        m.setWebsite("https://updateco.com");
        manufacturerRepository.save(m);

        Vehicle v = new Vehicle();
        v.setModelCode("update-v1");
        v.setName("Old Model");
        v.setDescription("Old description");
        v.setPrice(38000.0);
        v.setSeats(4);
        v.setRange(300);
        v.setBatteryCapacity(70.0);
        v.setHorsepower(150);
        v.setType("Sedan");
        v.setManufacturer(m);
        vehicleRepository.save(v);

        ObjectNode dto = objectMapper.createObjectNode();
        dto.put("modelCode", "update-v1");
        dto.put("name", "Updated Model");
        dto.put("description", "New description");
        dto.put("range", 500);
        dto.put("price", 40000.0);
        dto.put("seats", 5);
        dto.put("batteryCapacity", 85.0);
        dto.put("manufacturerId", "mfg-update");
        dto.put("horsepower", 220);
        dto.put("type", "Coupe");

        MockHttpServletResponse response = mockMvc.perform(
                put("/vehicles/update-v1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dto.toString())
        ).andReturn().getResponse();

        assertEquals(200, response.getStatus());

        Vehicle updated = vehicleRepository.findById("update-v1").orElseThrow();
        assertEquals("Updated Model", updated.getName());
        assertEquals("New description", updated.getDescription());
        assertEquals(85.0, updated.getBatteryCapacity());
    }

    @Test
    public void deleteVehicle() throws Exception {
        Vehicle v = new Vehicle();
        v.setModelCode("delete-v1");
        v.setName("Delete Me");
        v.setDescription("Should be removed");
        v.setPrice(33000.0);
        v.setSeats(4);
        v.setRange(350);
        v.setBatteryCapacity(65.0);
        v.setHorsepower(160);
        v.setType("Hatchback");
        vehicleRepository.save(v);

        MockHttpServletResponse response = mockMvc.perform(
                delete("/vehicles/delete-v1")
        ).andReturn().getResponse();

        assertEquals(200, response.getStatus());
        assertFalse(vehicleRepository.findById("delete-v1").isPresent());
    }
}
