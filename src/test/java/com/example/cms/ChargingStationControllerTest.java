package com.example.cms;

import com.example.cms.model.entity.ChargingStation;
import com.example.cms.model.repository.ChargingStationRepository;
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
public class ChargingStationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ChargingStationRepository chargingStationRepository;

    @Test
    public void addChargingStation() throws Exception {
        ObjectNode dto = objectMapper.createObjectNode();
        dto.put("location", "Test Location");
        dto.put("provider", "Test Provider");
        dto.put("capacity", 10);

        MockHttpServletResponse response = mockMvc.perform(
                post("/charging-stations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dto.toString())
        ).andReturn().getResponse();

        assertEquals(200, response.getStatus());

        boolean found = chargingStationRepository.findAll()
                .stream()
                .anyMatch(cs -> "Test Location".equals(cs.getLocation()) &&
                        "Test Provider".equals(cs.getProvider()));

        assertTrue(found);
    }

    @Test
    public void getAllChargingStations() throws Exception {
        ChargingStation cs = new ChargingStation();
        cs.setLocation("Central Station");
        cs.setProvider("EVCo");
        cs.setCapacity(8);
        chargingStationRepository.save(cs);

        MockHttpServletResponse response = mockMvc.perform(
                get("/charging-stations")
        ).andReturn().getResponse();

        assertEquals(200, response.getStatus());
        assertTrue(response.getContentAsString().contains("Central Station"));
    }

    @Test
    public void getChargingStationById() throws Exception {
        ChargingStation cs = new ChargingStation();
        cs.setLocation("Downtown");
        cs.setProvider("GridPoint");
        cs.setCapacity(5);
        ChargingStation saved = chargingStationRepository.save(cs);

        MockHttpServletResponse response = mockMvc.perform(
                get("/charging-stations/" + saved.getId())
        ).andReturn().getResponse();

        assertEquals(200, response.getStatus());
        assertTrue(response.getContentAsString().contains("Downtown"));
    }

    @Test
    public void updateChargingStation() throws Exception {
        ChargingStation cs = new ChargingStation();
        cs.setLocation("Old Place");
        cs.setProvider("Old Provider");
        cs.setCapacity(2);
        ChargingStation saved = chargingStationRepository.save(cs);

        ObjectNode dto = objectMapper.createObjectNode();
        dto.put("location", "Updated Place");
        dto.put("provider", "Updated Provider");
        dto.put("capacity", 20);

        MockHttpServletResponse response = mockMvc.perform(
                put("/charging-stations/" + saved.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dto.toString())
        ).andReturn().getResponse();

        assertEquals(200, response.getStatus());

        ChargingStation updated = chargingStationRepository.findById(saved.getId()).orElseThrow();
        assertEquals("Updated Place", updated.getLocation());
        assertEquals("Updated Provider", updated.getProvider());
        assertEquals(20, updated.getCapacity());
    }

    @Test
    public void deleteChargingStation() throws Exception {
        ChargingStation cs = new ChargingStation();
        cs.setLocation("To Delete");
        cs.setProvider("ZapInc");
        cs.setCapacity(6);
        ChargingStation saved = chargingStationRepository.save(cs);

        MockHttpServletResponse response = mockMvc.perform(
                delete("/charging-stations/" + saved.getId())
        ).andReturn().getResponse();

        assertEquals(200, response.getStatus());
        assertFalse(chargingStationRepository.findById(saved.getId()).isPresent());
    }
}