package com.nerfo.parking.service;

import com.nerfo.parking.model.Vehiculo;
import com.nerfo.parking.repository.VehiculoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class VehiculoServiceTest {

    @Autowired
    private VehiculoService vehiculoService;

    @MockBean
    private VehiculoRepository vehiculoRepository;

    @Test
    public void testSaveVehiculo() {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setPlaca("ABC123");

        when(vehiculoRepository.save(vehiculo)).thenReturn(vehiculo);

        Vehiculo savedVehiculo = vehiculoService.saveVehiculo(vehiculo);

        assertThat(savedVehiculo.getPlaca()).isEqualTo("ABC123");
    }

    @Test
    public void testGetVehiculoById() {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setId(1L);
        vehiculo.setPlaca("ABC123");

        when(vehiculoRepository.findById(1L)).thenReturn(Optional.of(vehiculo));

        Optional<Vehiculo> retrievedVehiculo = vehiculoService.getVehiculoById(1L);

        assertThat(retrievedVehiculo.isPresent()).isTrue();
        assertThat(retrievedVehiculo.get().getPlaca()).isEqualTo("ABC123");
    }
}