package com.example.cms;

import com.example.cms.model.entity.Manufacturer;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ManufacturerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Test
    public void createManufacturer() throws Exception {
        ObjectNode dto = objectMapper.createObjectNode();
        dto.put("id", "mfg-test");
        dto.put("name", "Test Manufacturer");
        dto.put("country", "Testland");
        dto.put("website", "https://test.com");

        MockHttpServletResponse response = mockMvc.perform(
                post("/manufacturers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dto.toString())
        ).andReturn().getResponse();

        assertEquals(200, response.getStatus());
        assertTrue(manufacturerRepository.findById("mfg-test").isPresent());
    }

    @Test
    public void getManufacturerById() throws Exception {
        Manufacturer mfg = new Manufacturer();
        mfg.setId("mfg-123");
        mfg.setName("GetCo");
        mfg.setCountry("Fetchistan");
        mfg.setWebsite("https://getco.com");
        manufacturerRepository.save(mfg);

        MockHttpServletResponse response = mockMvc.perform(
                get("/manufacturers/mfg-123")
        ).andReturn().getResponse();

        assertEquals(200, response.getStatus());
        assertTrue(response.getContentAsString().contains("GetCo"));
    }

    @Test
    public void updateManufacturer() throws Exception {
        Manufacturer mfg = new Manufacturer();
        mfg.setId("mfg-update");
        mfg.setName("Old Name");
        mfg.setCountry("Old Country");
        mfg.setWebsite("https://old.com");
        manufacturerRepository.save(mfg);

        ObjectNode dto = objectMapper.createObjectNode();
        dto.put("name", "Updated Name");
        dto.put("country", "New Country");
        dto.put("website", "https://new.com");

        MockHttpServletResponse response = mockMvc.perform(
                put("/manufacturers/mfg-update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dto.toString())
        ).andReturn().getResponse();

        assertEquals(200, response.getStatus());

        Manufacturer updated = manufacturerRepository.findById("mfg-update").orElseThrow();
        assertEquals("Updated Name", updated.getName());
        assertEquals("New Country", updated.getCountry());
        assertEquals("https://new.com", updated.getWebsite());
    }

    @Test
    public void deleteManufacturer() throws Exception {
        Manufacturer mfg = new Manufacturer();
        mfg.setId("mfg-delete");
        mfg.setName("To Delete");
        mfg.setCountry("Gone");
        mfg.setWebsite("https://delete.com");
        manufacturerRepository.save(mfg);

        MockHttpServletResponse response = mockMvc.perform(
                delete("/manufacturers/mfg-delete")
        ).andReturn().getResponse();

        assertEquals(200, response.getStatus());
        assertFalse(manufacturerRepository.findById("mfg-delete").isPresent());
    }
}
