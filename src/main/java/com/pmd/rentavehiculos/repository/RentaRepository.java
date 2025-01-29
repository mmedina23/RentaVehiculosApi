package com.pmd.rentavehiculos.repository;

import com.pmd.rentavehiculos.entity.Renta;
import com.pmd.rentavehiculos.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RentaRepository extends JpaRepository<Renta, Integer> {

    @Query(value = "SELECT * FROM rentas WHERE vehiculo_id = :idVehiculo", nativeQuery = true)
    List<Renta> rentaPorIdVehiculo(@Param("idVehiculo") Integer idVehiculo);
}
