package com.pmd.rentavehiculos.mapper;

import com.pmd.rentavehiculos.entity.Persona;
import com.pmd.rentavehiculos.entity.Usuario;
import com.pmd.rentavehiculos.model.AutenticacionDto;
import com.pmd.rentavehiculos.model.PersonaDto;

public class Mapper {

    public static PersonaDto personaEntityToPersonaDto(Persona persona) {
        return new PersonaDto()
                .id(persona.getId())
                .nombre(persona.getNombre())
                .apellidos(persona.getApellidos())
                .telefono(persona.getTelefono())
                .direccion(persona.getDireccion())
                .tipoIdentificacion(PersonaDto.TipoIdentificacionEnum.fromValue(persona.getTipoIdentificacion()))
                .identificacion(persona.getIdentificacion());
    }

    public static AutenticacionDto mapperAutenticacionDto(Persona persona, Usuario usuario){
        return new AutenticacionDto()
                .persona(personaEntityToPersonaDto(persona))
                .llave(usuario.getLlave())
                .fechaExpLlave(usuario.getFechaExpLlave());
    }
}
