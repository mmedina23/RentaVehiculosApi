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
        Optional<Usuario> usuarioEntity  = this.usuarioRepository.login(usuario,contrasena);

        return usuarioEntity.map(it -> {
            it.setLlave(Util.generarLlaveUsuario());
            it.setFechaExpLlave(LocalDateTime.now().plusDays(1
            ));

            this.usuarioRepository.actualizarLLave(
                    it.getId(),
                    it.getLlave(),
                    it.getFechaExpLlave());

            return it;
        }).orElseThrow(() -> new RuntimeException("Usuario o Contrasena Erroneo"));

    }

    public void logout(Integer idUsuario, String llave) {
        this.usuarioRepository.findById(idUsuario)
                .filter(it ->
                    llave.equals(it.getLlave())
                            && null != it.getFechaExpLlave()
                            && LocalDateTime.now().isAfter(it.getFechaExpLlave())
                ).ifPresent(it -> {
                    it.setLlave(null);
                    it.setFechaExpLlave(null);
                    this.usuarioRepository.save(it);
                });
    }

    public boolean verificacionLlave(String llave){
        return this.usuarioRepository.consultaPorLlave(llave).map(it ->
                LocalDateTime.now().isBefore(it.getFechaExpLlave())
                ).orElse(false);
    }
}
