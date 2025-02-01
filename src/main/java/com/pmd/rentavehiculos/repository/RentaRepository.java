package com.pmd.rentavehiculos.repository;

import com.pmd.rentavehiculos.entity.Renta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentaRepository extends JpaRepository<Renta, Integer> {

    @Query(value = "SELECT * FROM rentas WHERE vehiculo_id = :idVehiculo", nativeQuery = true)
    List<Renta> rentaPorIdVehiculo(@Param("idVehiculo") Integer idVehiculo);

    @Query(value = "SELECT * FROM rentas WHERE persona_id = :id and fecha_entregado is null", nativeQuery = true)
    List<Renta> rentasPorIdPersona(@Param("id") Integer id);

}
