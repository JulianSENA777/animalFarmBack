package com.granja.animal_farm_web.business;

import com.granja.animal_farm_web.Dto.ParteAfectadaDto;
import com.granja.animal_farm_web.Entity.ParteAfectada;
import com.granja.animal_farm_web.Services.ParteAfectadaService;
import com.granja.animal_farm_web.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParteAfectadaBusiness {
    @Autowired
    private ParteAfectadaService parteAfectadaService;
    @Autowired
    private ModelMapper modelMapper;

    public ParteAfectadaDto crearParteAfectada(ParteAfectadaDto parteAfectadaDto) {
        validarCoherenciaDatos(parteAfectadaDto);
        ParteAfectada parteAfectada = modelMapper.map(parteAfectadaDto, ParteAfectada.class);
        ParteAfectada creado = parteAfectadaService.crearParteAfectada(parteAfectada);
        return modelMapper.map(creado, ParteAfectadaDto.class);
    }

    private void validarCoherenciaDatos(ParteAfectadaDto parteAfectadaDto) {
        if (parteAfectadaDto.getNombreParteAfectada() == null || parteAfectadaDto.getNombreParteAfectada().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la parte afectada no puede estar vacío");
        }
        if (parteAfectadaDto.getCategoria() == null || parteAfectadaDto.getCategoria().trim().isEmpty()) {
            throw new IllegalArgumentException("La categoría no puede estar vacía");
        }
    }

    private ParteAfectada validarExistenciaParteAfectada(int id) {
        ParteAfectada parteAfectada = parteAfectadaService.obtenerParteAfectadaPorId(id);
        if (parteAfectada == null) {
            throw new NotFoundException("Parte afectada no encontrada con id: " + id);
        }
        return parteAfectada;
    }

    public List<ParteAfectadaDto> listarPartesAfectadas() {
        return parteAfectadaService.listarPartesAfectadas().stream()
            .map(parteAfectada -> modelMapper.map(parteAfectada, ParteAfectadaDto.class))
            .collect(Collectors.toList());
    }

    public ParteAfectadaDto actualizarParteAfectada(int id, ParteAfectadaDto parteAfectadaDto) {
        validarExistenciaParteAfectada(id);
        validarCoherenciaDatos(parteAfectadaDto);
        ParteAfectada parteAfectada = modelMapper.map(parteAfectadaDto, ParteAfectada.class);
        ParteAfectada actualizado = parteAfectadaService.actualizarParteAfectada(id, parteAfectada);
        return modelMapper.map(actualizado, ParteAfectadaDto.class);
    }

    public ParteAfectadaDto obtenerParteAfectadaPorId(int id) {
        ParteAfectada parteAfectada = validarExistenciaParteAfectada(id);
        return modelMapper.map(parteAfectada, ParteAfectadaDto.class);
    }
}

