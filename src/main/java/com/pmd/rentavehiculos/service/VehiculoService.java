package com.pmd.rentavehiculos.service;

import com.pmd.rentavehiculos.entity.Renta;
import com.pmd.rentavehiculos.entity.Vehiculo;
import com.pmd.rentavehiculos.repository.RentaRepository;
import com.pmd.rentavehiculos.repository.VehiculoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;
    private final RentaRepository rentaRepository;

    public VehiculoService(VehiculoRepository vehiculoRepository, RentaRepository rentaRepository) {
        this.vehiculoRepository = vehiculoRepository;
        this.rentaRepository = rentaRepository;
    }

    public void liberarRentaVehiculo(Integer id) {
        this.rentaRepository
                .rentaPorIdVehiculo(id).stream()
                .filter(it -> it.getFechaEntregado() == null)
                .findFirst()
                .ifPresent(renta -> {
                    renta.setFechaEntregado(LocalDateTime.now());
                    this.rentaRepository.save(renta);
                } );

        this.vehiculoRepository.findById(id)
                .ifPresent(it -> {
                    it.setDisponible(true);
                    this.vehiculoRepository.save(it);

                }
        );
        //falta excepcion
    }

    public List<Renta> obtenerRentasVehiculoPorId(Integer id) {
        return this.rentaRepository.rentaPorIdVehiculo(id);
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

    public void reservarVehiculo(Integer id, Renta renta) {
        Optional<Vehiculo> vehiculo = obtenerVehiculoPorId(id);
        if (vehiculo.get().isDisponible()){
            vehiculo.ifPresent(it -> {
                        it.setDisponible(false);

                        Vehiculo vehiculoEntity = new Vehiculo();
                        vehiculoEntity.setId(id);
                        renta.setVehiculo(vehiculoEntity);

                        this.rentaRepository.save(renta);
                        this.vehiculoRepository.save(it);
                    }
            );
        }else {
            throw new RuntimeException("El vehiculo no esta disponible");
        }

        //Falta excepcion
    }
}
