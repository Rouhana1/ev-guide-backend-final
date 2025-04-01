package com.example.cms;

import com.example.cms.model.entity.UserPreferences;
import com.example.cms.model.entity.Manufacturer;
import com.example.cms.model.entity.Vehicle;
import com.example.cms.model.repository.UserPreferencesRepository;
import com.example.cms.model.repository.VehicleRepository;
import com.example.cms.model.repository.ManufacturerRepository;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserPreferencesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private UserPreferencesRepository preferencesRepository;

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Test
    public void submitPreferencesAndGetMatchingVehicles() throws Exception {
        Manufacturer m = new Manufacturer();
        m.setId("mfg-prefs");
        m.setName("MatchMaker");
        m.setCountry("AutoLand");
        m.setWebsite("https://matchmaker.com");
        manufacturerRepository.save(m);

        Vehicle v1 = new Vehicle();
        v1.setModelCode("match-v1");
        v1.setName("Eagle One");
        v1.setDescription("Perfect match vehicle");
        v1.setPrice(40000.0);
        v1.setSeats(5);
        v1.setRange(500);
        v1.setHorsepower(200);
        v1.setType("SUV");
        v1.setBatteryCapacity(85.0);
        v1.setManufacturer(m);
        vehicleRepository.save(v1);

        Vehicle v2 = new Vehicle();
        v2.setModelCode("mismatch-v1");
        v2.setName("Mismatch Car");
        v2.setDescription("Too expensive and small");
        v2.setPrice(80000.0);
        v2.setSeats(2);
        v2.setRange(150);
        v2.setHorsepower(100);
        v2.setType("Sedan");
        v2.setBatteryCapacity(60.0);
        v2.setManufacturer(m);
        vehicleRepository.save(v2);

        ObjectNode dto = objectMapper.createObjectNode();
        dto.put("fullName", "Jane Doe");
        dto.put("budget", 50000.0);
        dto.put("seats", 4);
        dto.put("minRange", 300);
        dto.put("minHorsepower", 150);
        dto.put("preferredManufacturerId", "mfg-prefs");
        dto.put("type", "SUV");

        MockHttpServletResponse response = mockMvc.perform(
                post("/preferences")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dto.toString())
        ).andReturn().getResponse();

        assertEquals(200, response.getStatus());

        String responseBody = response.getContentAsString();
        assertTrue(responseBody.contains("Eagle One"));
        assertFalse(responseBody.contains("Mismatch Car"));

        boolean saved = preferencesRepository.findAll().stream()
                .anyMatch(p -> "Jane Doe".equals(p.getFullName()));
        assertTrue(saved);
    }
}
