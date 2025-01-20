package com.pmd.rentavehiculos.service;

import com.pmd.rentavehiculos.model.RentaDto;
import com.pmd.rentavehiculos.model.VehiculoDto;
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
        return ;
    }

    public List<RentaDto> obtenerRentasVehiculoPorId(Integer id) {
        return null;
    }

    public List<VehiculoDto> obtenerVehiculo(String estado) {
        return null;
    }

    public Optional<VehiculoDto> obtenerVehiculoPorId(Integer id) {
        return null;
    }

    public void reservarVehiculo(Integer id, RentaDto rentaDto) {
        return ;
    }
}
