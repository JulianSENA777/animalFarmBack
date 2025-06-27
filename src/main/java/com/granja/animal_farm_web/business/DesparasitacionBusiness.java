package com.granja.animal_farm_web.business;

import com.granja.animal_farm_web.Dto.DesparasitacionDto;
import com.granja.animal_farm_web.Entity.Desparasitacion;
import com.granja.animal_farm_web.Services.DesparasitacionService;
import com.granja.animal_farm_web.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DesparasitacionBusiness {
    @Autowired
    private DesparasitacionService desparasitacionService;
    @Autowired
    private ModelMapper modelMapper;

    public DesparasitacionDto crearDesparasitacion(DesparasitacionDto desparasitacionDto) {
        validarCoherenciaDatos(desparasitacionDto);
        Desparasitacion desparasitacion = modelMapper.map(desparasitacionDto, Desparasitacion.class);
        Desparasitacion creado = desparasitacionService.crearDesparasitacion(desparasitacion);
        return modelMapper.map(creado, DesparasitacionDto.class);
    }

    private void validarCoherenciaDatos(DesparasitacionDto desparasitacionDto) {
        if (desparasitacionDto.getTipoParasito() == null || desparasitacionDto.getTipoParasito().trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de parásito no puede estar vacío");
        }
        if (desparasitacionDto.getMedicamentoUsado() == null || desparasitacionDto.getMedicamentoUsado().trim().isEmpty()) {
            throw new IllegalArgumentException("El medicamento usado no puede estar vacío");
        }
    }

    private Desparasitacion validarExistenciaDesparasitacion(int id) {
        Desparasitacion desparasitacion = desparasitacionService.obtenerDesparasitacionPorId(id);
        if (desparasitacion == null) {
            throw new NotFoundException("Desparasitación no encontrada con id: " + id);
        }
        return desparasitacion;
    }

    public List<DesparasitacionDto> listarDesparasitaciones() {
        return desparasitacionService.listarDesparasitaciones().stream()
            .map(desparasitacion -> modelMapper.map(desparasitacion, DesparasitacionDto.class))
            .collect(Collectors.toList());
    }

    public DesparasitacionDto actualizarDesparasitacion(int id, DesparasitacionDto desparasitacionDto) {
        validarExistenciaDesparasitacion(id);
        validarCoherenciaDatos(desparasitacionDto);
        Desparasitacion desparasitacion = modelMapper.map(desparasitacionDto, Desparasitacion.class);
        Desparasitacion actualizado = desparasitacionService.actualizarDesparasitacion(id, desparasitacion);
        return modelMapper.map(actualizado, DesparasitacionDto.class);
    }

    public DesparasitacionDto obtenerDesparasitacionPorId(int id) {
        Desparasitacion desparasitacion = validarExistenciaDesparasitacion(id);
        return modelMapper.map(desparasitacion, DesparasitacionDto.class);
    }
}

