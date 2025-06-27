package com.granja.animal_farm_web.Services;

import com.granja.animal_farm_web.Entity.Desparasitacion;
import com.granja.animal_farm_web.exception.NotFoundException;
import com.granja.animal_farm_web.repository.DesparasitacionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DesparasitacionService {
    @Autowired
    private DesparasitacionRepo desparasitacionRepo;

    public Desparasitacion crearDesparasitacion(Desparasitacion desparasitacion) {
        return desparasitacionRepo.save(desparasitacion);
    }

    public List<Desparasitacion> listarDesparasitaciones() {
        return desparasitacionRepo.findAll();
    }

    public Desparasitacion actualizarDesparasitacion(int id, Desparasitacion desparasitacion) {
        Desparasitacion existente = desparasitacionRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Desparasitación no encontrada con id: " + id));
        desparasitacion.setDesparasitacionId(id);
        return desparasitacionRepo.save(desparasitacion);
    }

    public Desparasitacion obtenerDesparasitacionPorId(int id) {
        return desparasitacionRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Desparasitación no encontrada con id: " + id));
    }
}
