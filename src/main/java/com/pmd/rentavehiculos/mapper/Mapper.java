package com.pmd.rentavehiculos.mapper;

import com.pmd.rentavehiculos.entity.Persona;
import com.pmd.rentavehiculos.entity.Renta;
import com.pmd.rentavehiculos.entity.Usuario;
import com.pmd.rentavehiculos.entity.Vehiculo;
import com.pmd.rentavehiculos.model.AutenticacionDto;
import com.pmd.rentavehiculos.model.PersonaDto;
import com.pmd.rentavehiculos.model.RentaDto;
import com.pmd.rentavehiculos.model.VehiculoDto;

import java.time.LocalDateTime;

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
                .perfil(AutenticacionDto.PerfilEnum.valueOf(usuario.getPerfil()))
                .llave(usuario.getLlave())
                .fechaExpLlave(usuario.getFechaExpLlave());
    }

    public static VehiculoDto vehiculoEntityToHehiculoDto(Vehiculo vehiculo){
       return new VehiculoDto()
                .id(vehiculo.getId())
                .marca(vehiculo.getMarca())
                .color(vehiculo.getColor())
                .carroceria(VehiculoDto.CarroceriaEnum.fromValue(vehiculo.getCarroceria()))
                .plazas(vehiculo.getPlazas())
                .cambios(VehiculoDto.CambiosEnum.fromValue(vehiculo.getCambios()))
                .tipoCombustible(vehiculo.getTipoCombustible())
                .valorDia(vehiculo.getValorDia())
                .disponible(vehiculo.isDisponible());
    }

    public static Vehiculo vehiculoDtoVehiculoEntity(VehiculoDto vehiculoDto){
        Vehiculo vehiculo =  new Vehiculo();
        vehiculo.setMarca(vehiculoDto.getMarca());
        vehiculo.setColor(vehiculoDto.getColor());
        vehiculo.setCarroceria(vehiculoDto.getCarroceria().getValue());
        vehiculo.setPlazas(vehiculoDto.getPlazas());
        vehiculo.setCambios(vehiculoDto.getCambios().getValue());
        vehiculo.setTipoCombustible(vehiculoDto.getTipoCombustible());
        vehiculo.setValorDia(vehiculoDto.getValorDia());
        vehiculo.setDisponible(vehiculoDto.getDisponible());

        return vehiculo;
    }

    public static Renta rentaDtoToRentaEntity(RentaDto rentaDto){
        Renta renta =  new Renta();
        Persona persona = new Persona();

        persona.setId(rentaDto.getPersona().getId());

        renta.setPersona(persona);
        renta.setDiasRenta(rentaDto.getDiasRenta());
        renta.setValorTotalRenta(rentaDto.getValorTotalRenta());
        renta.setFechaRenta(LocalDateTime.now());
        renta.setFechaEstimadaEntrega(rentaDto.getFechaEstimadaEntrega());
        renta.setFechaEntregado(renta.getFechaEntregado());

        return renta;
    }

    public static RentaDto rentaEntityToRentaDto(Renta renta){
        return new RentaDto()
                .id(renta.getId())
                .persona(personaEntityToPersonaDto(renta.getPersona()))
                .vehiculo(vehiculoEntityToHehiculoDto(renta.getVehiculo()))
                .diasRenta(renta.getDiasRenta())
                .valorTotalRenta(renta.getValorTotalRenta())
                .fechaRenta(renta.getFechaRenta())
                .fechaEstimadaEntrega(renta.getFechaEstimadaEntrega())
                .fechaEntregado(renta.getFechaEntregado());
    }

}
