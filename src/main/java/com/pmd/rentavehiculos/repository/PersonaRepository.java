package com.pmd.rentavehiculos.repository;

import com.pmd.rentavehiculos.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    @Query(value = "SELECT * FROM PERSONAS WHERE id_usuario = :idUsuario", nativeQuery = true)
    Persona buscarPorIdUsuario(@Param("idUsuario") Integer idUsuario);
}
