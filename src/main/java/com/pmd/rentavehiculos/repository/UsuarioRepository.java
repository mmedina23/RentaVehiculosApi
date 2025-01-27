package com.pmd.rentavehiculos.repository;

import com.pmd.rentavehiculos.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(value = "SELECT * FROM usuarios WHERE usuario = :usuario AND contrasena = :contrasena", nativeQuery = true)
    Optional<Usuario> login(@Param("usuario") String usuario, @Param("contrasena") String contrasena);

    @Modifying
    @Query(value = "UPDATE usuarios SET llave = :llave, fecha_exp_llave = :fechaExpLlave WHERE id = :idUsusario", nativeQuery = true)
    void actualizarLLave(@Param("idUsusario") Integer idUsusario, @Param("llave") String llave, @Param("fechaExpLlave") LocalDateTime fechaExpLlave);
}
