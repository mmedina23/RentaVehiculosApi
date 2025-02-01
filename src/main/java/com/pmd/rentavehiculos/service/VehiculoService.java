package com.pmd.rentavehiculos.service;

import com.pmd.rentavehiculos.entity.Vehiculo;
import com.pmd.rentavehiculos.exception.ReglaNegocioExcepcion;
import com.pmd.rentavehiculos.repository.VehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    public VehiculoService(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    public List<Vehiculo> obtenerVehiculo() {
        return this.vehiculoRepository.findAll();
    }

    public List<Vehiculo> obtenerVehiculoPorEstado(boolean disponible) {
        return this.vehiculoRepository.findByDisponible(disponible);
    }

    public Optional<Vehiculo> obtenerVehiculoPorId(Integer id) {
        return this.vehiculoRepository.findById(id);
    }

    public void reservarVehiculo(Integer id) {
        this.vehiculoRepository.findById(id)
                .filter(Vehiculo::isDisponible)
                .ifPresentOrElse(it -> {
                    it.setDisponible(Boolean.FALSE);
                    this.vehiculoRepository.save(it);
                }, () -> ReglaNegocioExcepcion.vehiculoNoDisponible.apply(id));
    }

    public void eliminarVehiculo(Integer id) {
        vehiculoRepository.deleteById(id);
    }

    public Vehiculo crearVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    public void actualizarVehiculo(Integer id, Vehiculo vehiculo) {
        vehiculoRepository.findById(id)
                .ifPresentOrElse(vhAlmacenado -> {
                    var vhMerge = vhAlmacenado.merge(vehiculo);
                    vehiculoRepository.save(vhMerge);
                }, () -> ReglaNegocioExcepcion.vehiculoNoExiste.apply(id));
    }
}
