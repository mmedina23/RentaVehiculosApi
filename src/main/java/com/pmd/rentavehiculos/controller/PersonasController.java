package com.pmd.rentavehiculos.controller;

import com.pmd.rentavehiculos.model.PersonaDto;
import com.pmd.rentavehiculos.service.PersonaService;
import com.pmd.rentavehiculos.web.PersonasApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PersonasController implements PersonasApi {

    private final PersonaService personaService;

    @Override
    public ResponseEntity<List<PersonaDto>> obtenerPersona() {
        var personas = personaService.obtenerPersona();
        var dtos = personas.stream().map(it ->
            new PersonaDto()
                    .id(it.getId())
                    .nombre(it.getNombre())
        ).toList();

        return ResponseEntity.ok(dtos);
    }

    @Override
    public ResponseEntity<PersonaDto> obtenerPersonaPorId(Integer id) {
        var persona = personaService.obtenerPersonaPorId(id);
        var dto = persona.map(it ->
                new PersonaDto()
                        .id(it.getId())
                        .nombre(it.getNombre())
        ).orElseThrow();

        return ResponseEntity.ok(dto);
    }
}
