package com.pmd.rentavehiculos.service;

import com.pmd.rentavehiculos.entity.Renta;
import com.pmd.rentavehiculos.entity.Vehiculo;
import com.pmd.rentavehiculos.repository.RentaRepository;
import com.pmd.rentavehiculos.repository.VehiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;
    private final RentaRepository rentaRepository;

    public void liberarRentaVehiculo(Integer id) {
        return;
    }

    public List<Renta> obtenerRentasVehiculoPorId(Integer id) {
        return null;
    }

    public List<Vehiculo> obtenerVehiculo() {
        return vehiculoRepository.findAll();
    }

    public List<Vehiculo> obtenerVehiculoPorEstado(boolean disponible) {
        return vehiculoRepository.findByDisponible(disponible);
    }

    public Optional<Vehiculo> obtenerVehiculoPorId(Integer id) {
        return vehiculoRepository.findById(id);
    }

    public void reservarVehiculo(Integer id, Renta renta) {
        return;
    }
}
