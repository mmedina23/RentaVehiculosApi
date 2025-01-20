package com.pmd.rentavehiculos.repository;

import com.pmd.rentavehiculos.entity.Vehiculo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends CrudRepository<Vehiculo, Integer> {
}
