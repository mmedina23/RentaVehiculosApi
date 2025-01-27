package com.pmd.rentavehiculos.service;

import com.pmd.rentavehiculos.entity.Usuario;
import com.pmd.rentavehiculos.repository.UsuarioRepository;
import com.pmd.rentavehiculos.util.Util;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public Usuario login(String usuario, String contrasena){
        Optional<Usuario> usuarioEntity  = usuarioRepository.login(usuario,contrasena);

        usuarioEntity.ifPresent(it ->
                usuarioRepository.actualizarLLave(
                        it.getId(),
                        Util.generarLlaveUsuario(),
                        LocalDateTime.now())
        );

        return usuarioEntity.orElseThrow(() -> new RuntimeException("Usuario o Contrasena Erroneo"));
    }

}
