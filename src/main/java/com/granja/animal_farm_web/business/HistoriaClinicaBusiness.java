package com.granja.animal_farm_web.business;

import com.granja.animal_farm_web.Dto.HistoriaClinicaDto;
import com.granja.animal_farm_web.Entity.HistoriaClinica;
import com.granja.animal_farm_web.Services.HistoriaClinicaService;
import com.granja.animal_farm_web.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class HistoriaClinicaBusiness {
    @Autowired
    private HistoriaClinicaService historiaClinicaService;
    @Autowired
    private ModelMapper modelMapper;

    public HistoriaClinicaDto crearHistoriaClinica(HistoriaClinicaDto historiaClinicaDto) {
        historiaClinicaDto.setHistoriaClinicaId(null);
        validarCoherenciaDatos(historiaClinicaDto);
        HistoriaClinica historiaClinica = modelMapper.map(historiaClinicaDto, HistoriaClinica.class);
        historiaClinica.setHistoriaClinicaId(null);
        HistoriaClinica creada = historiaClinicaService.crearHistoriaClinica(historiaClinica);
        return modelMapper.map(creada, HistoriaClinicaDto.class);
    }

    private void validarCoherenciaDatos(HistoriaClinicaDto historiaClinicaDto) {
        if (historiaClinicaDto.getResumenHistoria() == null || historiaClinicaDto.getResumenHistoria().trim().isEmpty()) {
            throw new IllegalArgumentException("El resumen de la historia clínica no puede estar vacío");
        }
    }

    private HistoriaClinica validarExistenciaHistoriaClinica(int id) {
        HistoriaClinica historiaClinica = historiaClinicaService.obtenerHistoriaClinicaPorId(id);
        if (historiaClinica == null) {
            throw new NotFoundException("Historia clínica no encontrada con id: " + id);
        }
        return historiaClinica;
    }

    public List<HistoriaClinicaDto> listarHistoriasClinicas() {
        return historiaClinicaService.listarHistoriasClinicas().stream()
            .map(historiaClinica -> modelMapper.map(historiaClinica, HistoriaClinicaDto.class))
            .collect(Collectors.toList());
    }

    public HistoriaClinicaDto actualizarHistoriaClinica(int id, HistoriaClinicaDto historiaClinicaDto) {
        validarExistenciaHistoriaClinica(id);
        validarCoherenciaDatos(historiaClinicaDto);
        HistoriaClinica historiaClinica = modelMapper.map(historiaClinicaDto, HistoriaClinica.class);
        HistoriaClinica actualizada = historiaClinicaService.actualizarHistoriaClinica(id, historiaClinica);
        return modelMapper.map(actualizada, HistoriaClinicaDto.class);
    }

    public HistoriaClinicaDto obtenerHistoriaClinicaPorId(int id) {
        HistoriaClinica historiaClinica = validarExistenciaHistoriaClinica(id);
        return modelMapper.map(historiaClinica, HistoriaClinicaDto.class);
    }
}
