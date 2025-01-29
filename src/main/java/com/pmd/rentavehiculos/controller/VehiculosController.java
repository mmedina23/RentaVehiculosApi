package com.pmd.rentavehiculos.controller;

import com.pmd.rentavehiculos.entity.Renta;
import com.pmd.rentavehiculos.entity.Vehiculo;
import com.pmd.rentavehiculos.mapper.Mapper;
import com.pmd.rentavehiculos.model.RentaDto;
import com.pmd.rentavehiculos.model.VehiculoDto;
import com.pmd.rentavehiculos.service.VehiculoService;
import com.pmd.rentavehiculos.web.VehiculosApi;
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
    public ResponseEntity<Void> liberarRentaVehiculo(Integer id, String xLlaveApi) {
        this.vehiculoService.liberarRentaVehiculo(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<RentaDto>> obtenerRentasVehiculoPorId(Integer id, String xLlaveApi) {
        List<Renta> rentas = this.vehiculoService.obtenerRentasVehiculoPorId(id);
        var dtos = rentas.stream().map(Mapper::rentaEntityToRentaDto).toList();

        return ResponseEntity.ok(dtos);
    }

    @Override
    public ResponseEntity<List<VehiculoDto>> obtenerVehiculo(String xLlaveApi, String estado) {
        List<Vehiculo> vehiculos;
        if (null == estado) {
            vehiculos = this.vehiculoService.obtenerVehiculo();
        } else {
            boolean disponible = "disponibles".equals(estado);
            vehiculos = this.vehiculoService.obtenerVehiculoPorEstado(disponible);
        }

        var dtos = vehiculos.stream().map(Mapper::vehiculoEntityToHehiculoDto
        ).toList();

        return ResponseEntity.ok(dtos);
    }

    @Override
    public ResponseEntity<VehiculoDto> obtenerVehiculoPorId(Integer id, String xLlaveApi) {
        var vehiculo = this.vehiculoService.obtenerVehiculoPorId(id);
        var dto = vehiculo.map(Mapper::vehiculoEntityToHehiculoDto
        ).orElseThrow();

        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<Void> reservarVehiculo(Integer id, String xLlaveApi, RentaDto rentaDto) {
        this.vehiculoService.reservarVehiculo(id, Mapper.rentaDtoToRentaEntity(rentaDto));
        return ResponseEntity.ok().build();
    }
}
