package com.granja.animal_farm_web.business;

import com.granja.animal_farm_web.Dto.UbicacionDto;
import com.granja.animal_farm_web.Entity.Ubicacion;
import com.granja.animal_farm_web.Services.UbicacionService;
import com.granja.animal_farm_web.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UbicacionBusiness {
    @Autowired
    private UbicacionService ubicacionService;
    @Autowired
    private ModelMapper modelMapper;

    public UbicacionDto crearUbicacion(UbicacionDto ubicacionDto) {
        validarCoherenciaDatos(ubicacionDto);
        Ubicacion ubicacion = modelMapper.map(ubicacionDto, Ubicacion.class);
        Ubicacion creado = ubicacionService.crearUbicacion(ubicacion);
        return modelMapper.map(creado, UbicacionDto.class);
    }

    private void validarCoherenciaDatos(UbicacionDto ubicacionDto) {
        if (ubicacionDto.getTipoUbicacion() == null || ubicacionDto.getTipoUbicacion().trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de ubicación no puede estar vacío");
        }
    }

    private Ubicacion validarExistenciaUbicacion(int id) {
        Ubicacion ubicacion = ubicacionService.obtenerUbicacionPorId(id);
        if (ubicacion == null) {
            throw new NotFoundException("Ubicación no encontrada con id: " + id);
        }
        return ubicacion;
    }

    public List<UbicacionDto> listarUbicaciones() {
        return ubicacionService.listarUbicaciones().stream()
            .map(ubicacion -> modelMapper.map(ubicacion, UbicacionDto.class))
            .collect(Collectors.toList());
    }

    public UbicacionDto actualizarUbicacion(int id, UbicacionDto ubicacionDto) {
        validarExistenciaUbicacion(id);
        validarCoherenciaDatos(ubicacionDto);
        Ubicacion ubicacion = modelMapper.map(ubicacionDto, Ubicacion.class);
        Ubicacion actualizado = ubicacionService.actualizarUbicacion(id, ubicacion);
        return modelMapper.map(actualizado, UbicacionDto.class);
    }

    public UbicacionDto obtenerUbicacionPorId(int id) {
        Ubicacion ubicacion = validarExistenciaUbicacion(id);
        return modelMapper.map(ubicacion, UbicacionDto.class);
    }

    public UbicacionDto cambiarLimpiable(int id, boolean limpiable) {
        Ubicacion actualizado = ubicacionService.cambiarLimpiable(id, limpiable);
        return modelMapper.map(actualizado, UbicacionDto.class);
    }

    public UbicacionDto cambiarVentilado(int id, boolean ventilado) {
        Ubicacion actualizado = ubicacionService.cambiarVentilado(id, ventilado);
        return modelMapper.map(actualizado, UbicacionDto.class);
    }

    public UbicacionDto cambiarCerrado(int id, boolean cerrado) {
        Ubicacion actualizado = ubicacionService.cambiarCerrado(id, cerrado);
        return modelMapper.map(actualizado, UbicacionDto.class);
    }
}
