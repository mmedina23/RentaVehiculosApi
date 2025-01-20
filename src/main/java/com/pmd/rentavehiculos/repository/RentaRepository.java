package com.pmd.rentavehiculos.repository;

import com.pmd.rentavehiculos.entity.Renta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentaRepository extends CrudRepository<Renta, Integer> {
}
