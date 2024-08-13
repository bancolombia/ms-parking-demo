package com.nerfo.parking.controller;

import com.nerfo.parking.model.Vehiculo;
import com.nerfo.parking.service.VehiculoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

@WebMvcTest(VehiculoController.class)
public class VehiculoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VehiculoService vehiculoService;

    @Test
    public void testGetAllVehiculos() throws Exception {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setId(1L);
        vehiculo.setPlaca("ABC123");

        when(vehiculoService.getAllVehiculos()).thenReturn(Collections.singletonList(vehiculo));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/vehiculos")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].placa").value("ABC123"));
    }
}