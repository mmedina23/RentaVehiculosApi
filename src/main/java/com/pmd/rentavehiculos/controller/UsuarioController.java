package com.pmd.rentavehiculos.controller;

import com.pmd.rentavehiculos.entity.Persona;
import com.pmd.rentavehiculos.entity.Usuario;
import com.pmd.rentavehiculos.mapper.Mapper;
import com.pmd.rentavehiculos.model.AutenticacionDto;
import com.pmd.rentavehiculos.model.LoginRequestDto;
import com.pmd.rentavehiculos.service.PersonaService;
import com.pmd.rentavehiculos.service.UsuarioService;
import com.pmd.rentavehiculos.web.AutenticacionApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController implements AutenticacionApi {

    private final UsuarioService usuarioService;
    private final PersonaService personaService;

    public UsuarioController(UsuarioService usuarioService, PersonaService personaService) {
        this.usuarioService = usuarioService;
        this.personaService = personaService;
    }

    @Override
    public ResponseEntity<AutenticacionDto> login(LoginRequestDto loginRequestDto) {
        Usuario usuario = usuarioService.login(loginRequestDto.getNombreUsuario(), loginRequestDto.getContrasena());
        Persona persona = personaService.obtenerPersonaPorIdUsuario(usuario.getId());

        AutenticacionDto autenticacionDto = Mapper.mapperAutenticacionDto(persona, usuario);

        return ResponseEntity.ok(autenticacionDto);
    }

    @Override
    public ResponseEntity<Void> logout() {
        usuarioService.logout(null, null);
        return ResponseEntity.ok().build();
    }
}
