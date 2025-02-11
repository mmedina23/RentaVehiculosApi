package com.pmd.rentavehiculos.service;

import com.pmd.rentavehiculos.entity.Persona;
import com.pmd.rentavehiculos.repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> obtenerPersona() {
        return this.personaRepository.findAll();
    }

    public Optional<Persona> obtenerPersonaPorId(Integer id) {
        return this.personaRepository.findById(id);
    }

    public Persona obtenerPersonaPorIdUsuario(Integer idUsuario) {
        return this.personaRepository.buscarPorIdUsuario(idUsuario);
    }

}
