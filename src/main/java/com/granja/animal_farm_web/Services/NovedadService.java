package com.granja.animal_farm_web.Services;

import com.granja.animal_farm_web.Entity.Novedad;
import com.granja.animal_farm_web.exception.NotFoundException;
import com.granja.animal_farm_web.repository.NovedadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NovedadService {
    @Autowired
    private NovedadRepo novedadRepo;

    public Novedad crearNovedad(Novedad novedad) {
        return novedadRepo.save(novedad);
    }

    public List<Novedad> listarNovedades() {
        return novedadRepo.findAll();
    }

    public Novedad actualizarNovedad(int id, Novedad novedad) {
        Novedad existente = novedadRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Novedad no encontrada con id: " + id));
        novedad.setNovedadId(id);
        return novedadRepo.save(novedad);
    }

    public Novedad obtenerNovedadPorId(int id) {
        return novedadRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Novedad no encontrada con id: " + id));
    }
}

