package com.granja.animal_farm_web.business;

import com.granja.animal_farm_web.Entity.Novedad;
import com.granja.animal_farm_web.Dto.NovedadDto;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;
import com.granja.animal_farm_web.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.granja.animal_farm_web.Services.NovedadService;
import com.granja.animal_farm_web.repository.NovedadRepo;

@Component
public class NovedadBusiness {
    @Autowired
    private NovedadService novedadService;
    @Autowired
    private NovedadRepo novedadRepo;
    @Autowired
    private ModelMapper modelMapper;

    public NovedadDto crearNovedad(NovedadDto novedadDto) {
        novedadDto.setId(null);
        validarCoherenciaDatos(novedadDto);
        Novedad novedad = modelMapper.map(novedadDto, Novedad.class);
        novedad.setNovedadId(null);
        Novedad creada = novedadService.crearNovedad(novedad);
        return modelMapper.map(creada, NovedadDto.class);
    }

    private void validarCoherenciaDatos(NovedadDto novedadDto) {
        if (novedadDto.getTipo() == null) {
            throw new IllegalArgumentException("El tipo de evento es obligatorio");
        }
        if (novedadDto.getResumenNovedad() == null || novedadDto.getResumenNovedad().trim().isEmpty()) {
            throw new IllegalArgumentException("El resumen de la novedad no puede estar vacío");
        }
        // Puedes agregar más validaciones según reglas de negocio
    }

    private Novedad validarExistenciaNovedad(int id) {
        Novedad novedad = novedadService.obtenerNovedadPorId(id);
        if (novedad == null) {
            throw new NotFoundException("Novedad no encontrada con id: " + id);
        }
        return novedad;
    }

    public List<NovedadDto> listarNovedades() {
        return novedadService.listarNovedades().stream()
            .map(novedad -> modelMapper.map(novedad, NovedadDto.class))
            .collect(Collectors.toList());
    }

    public NovedadDto actualizarNovedad(int id, NovedadDto novedadDto) {
        validarExistenciaNovedad(id);
        validarCoherenciaDatos(novedadDto);
        Novedad novedad = modelMapper.map(novedadDto, Novedad.class);
        Novedad actualizada = novedadService.actualizarNovedad(id, novedad);
        return modelMapper.map(actualizada, NovedadDto.class);
    }

    public NovedadDto obtenerNovedadPorId(int id) {
        Novedad novedad = validarExistenciaNovedad(id);
        return modelMapper.map(novedad, NovedadDto.class);
    }
}
