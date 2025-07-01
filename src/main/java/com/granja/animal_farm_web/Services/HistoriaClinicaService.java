package com.granja.animal_farm_web.Services;

import com.granja.animal_farm_web.Entity.HistoriaClinica;
import com.granja.animal_farm_web.exception.NotFoundException;
import com.granja.animal_farm_web.repository.HistoriaClinicaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HistoriaClinicaService {
    @Autowired
    private HistoriaClinicaRepo historiaClinicaRepo;

    public HistoriaClinica crearHistoriaClinica(HistoriaClinica historiaClinica) {
        return historiaClinicaRepo.save(historiaClinica);
    }

    public List<HistoriaClinica> listarHistoriasClinicas() {
        return historiaClinicaRepo.findAll();
    }

    public HistoriaClinica actualizarHistoriaClinica(int id, HistoriaClinica historiaClinica) {
        HistoriaClinica existente = historiaClinicaRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Historia clínica no encontrada con id: " + id));
        historiaClinica.setHistoriaClinicaId(id);
        return historiaClinicaRepo.save(historiaClinica);
    }

    public HistoriaClinica obtenerHistoriaClinicaPorId(int id) {
        return historiaClinicaRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Historia clínica no encontrada con id: " + id));
    }
}

