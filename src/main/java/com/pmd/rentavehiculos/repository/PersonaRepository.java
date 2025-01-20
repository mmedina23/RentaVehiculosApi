package com.pmd.rentavehiculos.repository;

import com.pmd.rentavehiculos.entity.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Integer> {
}
