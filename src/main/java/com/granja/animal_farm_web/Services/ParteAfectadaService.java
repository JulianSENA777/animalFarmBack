package com.granja.animal_farm_web.Services;

import com.granja.animal_farm_web.Entity.ParteAfectada;
import com.granja.animal_farm_web.exception.NotFoundException;
import com.granja.animal_farm_web.repository.ParteAfectadaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ParteAfectadaService {
    @Autowired
    private ParteAfectadaRepo parteAfectadaRepo;

    public ParteAfectada crearParteAfectada(ParteAfectada parteAfectada) {
        return parteAfectadaRepo.save(parteAfectada);
    }

    public List<ParteAfectada> listarPartesAfectadas() {
        return parteAfectadaRepo.findAll();
    }

    public ParteAfectada actualizarParteAfectada(int id, ParteAfectada parteAfectada) {
        ParteAfectada existente = parteAfectadaRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Parte afectada no encontrada con id: " + id));
        parteAfectada.setParteAfectadaId(id);
        return parteAfectadaRepo.save(parteAfectada);
    }

    public ParteAfectada obtenerParteAfectadaPorId(int id) {
        return parteAfectadaRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Parte afectada no encontrada con id: " + id));
    }
}

