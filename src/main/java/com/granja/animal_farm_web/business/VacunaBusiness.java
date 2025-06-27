package com.granja.animal_farm_web.business;

import com.granja.animal_farm_web.Dto.VacunaDto;
import com.granja.animal_farm_web.Entity.Vacuna;
import com.granja.animal_farm_web.Services.VacunaService;
import com.granja.animal_farm_web.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class VacunaBusiness {
    @Autowired
    private VacunaService vacunaService;
    @Autowired
    private ModelMapper modelMapper;

    public VacunaDto crearVacuna(VacunaDto vacunaDto) {
        validarCoherenciaDatos(vacunaDto);
        Vacuna vacuna = modelMapper.map(vacunaDto, Vacuna.class);
        Vacuna creado = vacunaService.crearVacuna(vacuna);
        return modelMapper.map(creado, VacunaDto.class);
    }

    private void validarCoherenciaDatos(VacunaDto vacunaDto) {
        if (vacunaDto.getNombreVacuna() == null || vacunaDto.getNombreVacuna().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la vacuna no puede estar vacío");
        }
        if (vacunaDto.getTipoVacuna() == null || vacunaDto.getTipoVacuna().trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de vacuna no puede estar vacío");
        }
    }

    private Vacuna validarExistenciaVacuna(int id) {
        Vacuna vacuna = vacunaService.obtenerVacunaPorId(id);
        if (vacuna == null) {
            throw new NotFoundException("Vacuna no encontrada con id: " + id);
        }
        return vacuna;
    }

    public List<VacunaDto> listarVacunas() {
        return vacunaService.listarVacunas().stream()
            .map(vacuna -> modelMapper.map(vacuna, VacunaDto.class))
            .collect(Collectors.toList());
    }

    public VacunaDto actualizarVacuna(int id, VacunaDto vacunaDto) {
        validarExistenciaVacuna(id);
        validarCoherenciaDatos(vacunaDto);
        Vacuna vacuna = modelMapper.map(vacunaDto, Vacuna.class);
        Vacuna actualizado = vacunaService.actualizarVacuna(id, vacuna);
        return modelMapper.map(actualizado, VacunaDto.class);
    }

    public VacunaDto obtenerVacunaPorId(int id) {
        Vacuna vacuna = validarExistenciaVacuna(id);
        return modelMapper.map(vacuna, VacunaDto.class);
    }
}

