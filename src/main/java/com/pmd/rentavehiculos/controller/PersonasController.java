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
        return null;
    }

    @Override
    public ResponseEntity<PersonaDto> obtenerPersonaPorId(Integer id) {
        return null;
    }
}
