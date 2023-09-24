package com.app.EPricingService.application.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetPriceAt10() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/aplicación/servicio/byProductId")
                    .param("brandId", "1")
                    .param("productId", "35455")
                    .param("date", "2023-06-14T10:00:00"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    @Test
    void testGetAppliedPriceAt10() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/aplicación/servicio/apply-price")
                .param("brandId", "1")
                .param("productId", "35455")
                .param("date", "2020-06-14T10:00:00")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    @Test
    void testGetAppliedPriceAt16() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/aplicación/servicio/apply-price")
                .param("brandId", "1")
                .param("productId", "35455")
                .param("date", "2020-06-14T16:00:00")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testGetAppliedPriceAt21() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/aplicación/servicio/apply-price")
                .param("brandId", "1")
                .param("productId", "35455")
                .param("date", "2020-06-14T21:00:00")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testGetAppliedPriceAt10NextDay() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/aplicación/servicio/apply-price")
                .param("brandId", "1")
                .param("productId", "35455")
                .param("date", "2020-06-15T10:00:00")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testGetAppliedPriceAt21DayAfter() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/aplicación/servicio/apply-price")
                .param("brandId", "1")
                .param("productId", "35455")
                .param("date", "2020-06-16T21:00:00")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}