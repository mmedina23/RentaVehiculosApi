package com.pmd.rentavehiculos.controller;

import com.pmd.rentavehiculos.mapper.Mapper;
import com.pmd.rentavehiculos.model.PersonaDto;
import com.pmd.rentavehiculos.service.PersonaService;
import com.pmd.rentavehiculos.web.PersonasApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonasController implements PersonasApi {

    private final PersonaService personaService;

    public PersonasController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @Override
    public ResponseEntity<List<PersonaDto>> obtenerPersona() {
        var personas = personaService.obtenerPersona();
        var dtos = personas.stream().map(Mapper::personaEntityToPersonaDto
        ).toList();

        return ResponseEntity.ok(dtos);
    }

    @Override
    public ResponseEntity<PersonaDto> obtenerPersonaPorId(Integer id) {
        var persona = personaService.obtenerPersonaPorId(id);
        var dto = persona.map(Mapper::personaEntityToPersonaDto
        ).orElseThrow();

        return ResponseEntity.ok(dto);
    }
}
