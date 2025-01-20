package com.pmd.rentavehiculos.repository;

import com.pmd.rentavehiculos.entity.Renta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentaRepository extends JpaRepository<Renta, Integer> {
}
