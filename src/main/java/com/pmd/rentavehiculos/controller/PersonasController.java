package com.pmd.rentavehiculos.controller;

import com.pmd.rentavehiculos.exception.ReglaNegocioExcepcion;
import com.pmd.rentavehiculos.mapper.Mapper;
import com.pmd.rentavehiculos.model.PersonaDto;
import com.pmd.rentavehiculos.model.RentaDto;
import com.pmd.rentavehiculos.service.PersonaService;
import com.pmd.rentavehiculos.service.RentaService;
import com.pmd.rentavehiculos.service.UsuarioService;
import com.pmd.rentavehiculos.web.PersonasApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonasController implements PersonasApi {

    private final PersonaService personaService;
    private final RentaService rentaService;
    private final UsuarioService usuarioService;

    public PersonasController(PersonaService personaService, RentaService rentaService, UsuarioService usuarioService) {
        this.personaService = personaService;
        this.rentaService = rentaService;
        this.usuarioService = usuarioService;
    }

    @Override
    public ResponseEntity<List<PersonaDto>> obtenerPersona(String xLlaveApi) {
        var personas = this.personaService.obtenerPersona();
        var dtos = personas.stream().map(Mapper::personaEntityToPersonaDto
        ).toList();

        return ResponseEntity.ok(dtos);
    }

    @Override
    public ResponseEntity<PersonaDto> obtenerPersonaPorId(Integer id, String xLlaveApi) {
        var persona = this.personaService.obtenerPersonaPorId(id);
        var dto = persona.map(Mapper::personaEntityToPersonaDto
        ).orElseThrow(()-> ReglaNegocioExcepcion.personaNoExiste);

        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<List<RentaDto>> obtenerRentasPorIdPersona(Integer id, String xLlaveApi) {
        this.usuarioService.validaPropietarioLlave(id, xLlaveApi);
        this.usuarioService.validaPerfilLlave("CLIENTE", xLlaveApi);

        var rentas = this.rentaService.obtenerRentasPorIdPersona(id)
                .stream().map(Mapper::rentaEntityToRentaDto)
                .toList();

        return ResponseEntity.ok(rentas);
    }

}
