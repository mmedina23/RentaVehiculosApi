package com.pmd.rentavehiculos.service;

import com.pmd.rentavehiculos.entity.Renta;
import com.pmd.rentavehiculos.entity.Vehiculo;
import com.pmd.rentavehiculos.exception.ReglaNegocioExcepcion;
import com.pmd.rentavehiculos.repository.RentaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RentaService {

    private final RentaRepository rentaRepository;

    public RentaService(RentaRepository rentaRepository) {
        this.rentaRepository = rentaRepository;
    }

    public List<Renta> obtenerRentasPorIdPersona(Integer id) {
        return rentaRepository.rentasPorIdPersona(id);
    }

    public List<Renta> obtenerRentasPorIdVehiculo(Integer id) {
        return this.rentaRepository.rentaPorIdVehiculo(id);
    }

    public void crearRentaVehiculo(Renta renta, Vehiculo vehiculo) {
        validacionDatosRenta(vehiculo, renta);
        this.rentaRepository.save(renta);
    }

    private void validacionDatosRenta(Vehiculo vehiculo, Renta renta){
        BigDecimal valorRenta =  vehiculo.getValorDia().multiply(BigDecimal.valueOf(renta.getDiasRenta()));

        if (valorRenta.compareTo(renta.getValorTotalRenta()) != 0){
            throw ReglaNegocioExcepcion.rentaInvalida;
        }
    }

    public void liberarRentaVehiculo(Integer idVehiculo) {
        this.rentaRepository
                .rentaPorIdVehiculo(idVehiculo).stream()
                .filter(it -> it.getFechaEntregado() == null)
                .findFirst()
                .ifPresentOrElse(renta -> {
                    renta.setFechaEntregado(LocalDateTime.now());
                    renta.getVehiculo().setDisponible(Boolean.TRUE);

                    this.rentaRepository.save(renta);
                }, () -> ReglaNegocioExcepcion.vehiculoNoDisponible.apply(idVehiculo));
    }
}
