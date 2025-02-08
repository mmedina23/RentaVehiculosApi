package com.pmd.rentavehiculos.controller;

import com.pmd.rentavehiculos.entity.Vehiculo;
import com.pmd.rentavehiculos.exception.ReglaNegocioExcepcion;
import com.pmd.rentavehiculos.mapper.Mapper;
import com.pmd.rentavehiculos.model.RentaDto;
import com.pmd.rentavehiculos.model.VehiculoDto;
import com.pmd.rentavehiculos.service.RentaService;
import com.pmd.rentavehiculos.service.UsuarioService;
import com.pmd.rentavehiculos.service.VehiculoService;
import com.pmd.rentavehiculos.web.VehiculosApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class VehiculosController implements VehiculosApi {

    private final VehiculoService vehiculoService;
    private final RentaService rentaService;
    private final UsuarioService usuarioService;

    public VehiculosController(VehiculoService vehiculoService, RentaService rentaService, UsuarioService usuarioService) {
        this.vehiculoService = vehiculoService;
        this.rentaService = rentaService;
        this.usuarioService = usuarioService;
    }

    @Override
    public ResponseEntity<Void> actualizarVehiculo(Integer id, String xLlaveApi, VehiculoDto vehiculoDto) {
        this.usuarioService.validaPerfilLlave("ADMIN", xLlaveApi);

        this.vehiculoService.actualizarVehiculo(id, Mapper.vehiculoDtoVehiculoEntity(vehiculoDto));
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @Override
    public ResponseEntity<Void> crearVehiculo(String xLlaveApi, VehiculoDto vehiculoDto) {
        this.usuarioService.validaPerfilLlave("ADMIN", xLlaveApi);

        this.vehiculoService.crearVehiculo(Mapper.vehiculoDtoVehiculoEntity(vehiculoDto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<Void> eliminarVehiculo(Integer id, String xLlaveApi) {
        this.usuarioService.validaPerfilLlave("ADMIN", xLlaveApi);

        this.vehiculoService.eliminarVehiculo(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> liberarRentaVehiculo(Integer id, String xLlaveApi) {
        this.usuarioService.validaPerfilLlave("CLIENTE", xLlaveApi);

        this.rentaService.liberarRentaVehiculo(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<RentaDto>> obtenerRentasVehiculoPorId(Integer id, String xLlaveApi) {
        this.usuarioService.validaPerfilLlave("ADMIN", xLlaveApi);

        List<RentaDto> rentas = this.rentaService.obtenerRentasPorIdVehiculo(id)
                .stream().map(Mapper::rentaEntityToRentaDto).toList();

        return ResponseEntity.ok(rentas);
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

        var dtos = vehiculos.stream()
                .map(Mapper::vehiculoEntityToHehiculoDto).toList();

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
        this.usuarioService.validaPropietarioLlave(rentaDto.getPersona().getId(), xLlaveApi);
        this.usuarioService.validaPerfilLlave("CLIENTE", xLlaveApi);

        Optional<Vehiculo> vehiculo = this.vehiculoService.obtenerVehiculoPorId(id);
        this.vehiculoService.reservarVehiculo(id);
        this.rentaService.crearRentaVehiculo(Mapper.rentaDtoToRentaEntity(rentaDto, id), vehiculo.get());

        return ResponseEntity.ok().build();
    }
}
