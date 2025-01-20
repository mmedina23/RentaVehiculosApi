package com.pmd.rentavehiculos.controller;

import com.pmd.rentavehiculos.entity.Vehiculo;
import com.pmd.rentavehiculos.model.RentaDto;
import com.pmd.rentavehiculos.model.VehiculoDto;
import com.pmd.rentavehiculos.service.VehiculoService;
import com.pmd.rentavehiculos.web.VehiculosApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehiculosController implements VehiculosApi {

    private final VehiculoService vehiculoService;

    public VehiculosController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

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
        List<Vehiculo> vehiculos;
        if (null == estado) {
            vehiculos = vehiculoService.obtenerVehiculo();
        } else {
            boolean disponible = "disponibles".equals(estado);
            vehiculos = vehiculoService.obtenerVehiculoPorEstado(disponible);
        }

        var dtos = vehiculos.stream().map(it ->
                new VehiculoDto()
                        .id(it.id)
                        .marca(it.marca)
                        .disponible(it.disponible)
        ).toList();

        return ResponseEntity.ok(dtos);
    }

    @Override
    public ResponseEntity<VehiculoDto> obtenerVehiculoPorId(Integer id) {
        var vehiculo = vehiculoService.obtenerVehiculoPorId(id);
        var dto = vehiculo.map(it ->
                new VehiculoDto()
                        .id(it.id)
                        .marca(it.marca)
                        .disponible(it.disponible)
                ).orElseThrow();

        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<Void> reservarVehiculo(Integer id, RentaDto rentaDto) {
        return null;
    }
}
