package com.pmd.rentavehiculos.service;

import com.pmd.rentavehiculos.model.PersonaDto;
import com.pmd.rentavehiculos.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    public List<PersonaDto> obtenerPersona() {
        return null;
    }

    public Optional<PersonaDto> obtenerPersonaPorId(Integer id) {
        return null;
    }
}
