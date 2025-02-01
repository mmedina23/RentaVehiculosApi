package com.pmd.rentavehiculos.service;

import com.pmd.rentavehiculos.entity.Usuario;
import com.pmd.rentavehiculos.exception.ReglaNegocioExcepcion;
import com.pmd.rentavehiculos.repository.UsuarioRepository;
import com.pmd.rentavehiculos.util.Util;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public Usuario login(String usuario, String contrasena) {
        return this.usuarioRepository.login(usuario, contrasena)
                .map(it -> {
                    it.setLlave(Util.generarLlaveUsuario());
                    it.setFechaExpLlave(LocalDateTime.now().plusDays(1));

                    this.usuarioRepository.actualizarLLave(
                            it.getId(),
                            it.getLlave(),
                            it.getFechaExpLlave());

                    return it;
                }).orElseThrow(() -> ReglaNegocioExcepcion.errorAutenticacion);

    }

    public void logout(Integer idUsuario, String llave) {
        this.usuarioRepository.consultaPorLlave(llave)
                .filter(it -> idUsuario.equals(it.getId()))
                .ifPresent(it -> {
                    it.setLlave(null);
                    it.setFechaExpLlave(null);
                    this.usuarioRepository.save(it);
                });
    }

    public boolean verificacionLlave(String llave) {
        return this.usuarioRepository.consultaPorLlave(llave)
                .map(it -> LocalDateTime.now().isBefore(it.getFechaExpLlave()))
                .orElse(false);
    }

    public void validaPropietarioLlave(Integer idPersona, String llave) {
        usuarioRepository.consultaPorLlave(llave)
                .filter(it -> idPersona.compareTo(it.getPersona().getId()) == 0)
                .orElseThrow(() -> ReglaNegocioExcepcion.usuarioNoAutorizado);
    }

    public void validaPerfilLlave(String perfil, String llave) {
        usuarioRepository.consultaPorLlave(llave)
                .filter(it -> perfil.equalsIgnoreCase(it.getPerfil()))
                .orElseThrow(() -> ReglaNegocioExcepcion.usuarioNoAutorizado);
    }

}
