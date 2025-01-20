package com.pmd.rentavehiculos.controller;

import com.pmd.rentavehiculos.model.RentaDto;
import com.pmd.rentavehiculos.model.VehiculoDto;
import com.pmd.rentavehiculos.service.VehiculoService;
import com.pmd.rentavehiculos.web.VehiculosApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class VehiculosController implements VehiculosApi {

    private final VehiculoService vehiculoService;

    @Override
    public ResponseEntity<Void> liberarRentaVehiculo(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<List<RentaDto>> obtenerRentasVehiculoPorId(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<List<VehiculoDto>> obtenerVehiculo(String estado) {
        return null;
    }

    @Override
    public ResponseEntity<VehiculoDto> obtenerVehiculoPorId(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<Void> reservarVehiculo(Integer id, RentaDto rentaDto) {
        return null;
    }
}
