package com.granja.animal_farm_web.Services;

import com.granja.animal_farm_web.Entity.Ubicacion;
import com.granja.animal_farm_web.exception.NotFoundException;
import com.granja.animal_farm_web.repository.UbicacionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UbicacionService {
    @Autowired
    private UbicacionRepo ubicacionRepo;

    public Ubicacion crearUbicacion(Ubicacion ubicacion) {
        return ubicacionRepo.save(ubicacion);
    }

    public List<Ubicacion> listarUbicaciones() {
        return ubicacionRepo.findAll();
    }

    public Ubicacion actualizarUbicacion(int id, Ubicacion ubicacion) {
        Ubicacion existente = ubicacionRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Ubicación no encontrada con id: " + id));
        ubicacion.setUbicacionId(id);
        return ubicacionRepo.save(ubicacion);
    }

    public Ubicacion obtenerUbicacionPorId(int id) {
        return ubicacionRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Ubicación no encontrada con id: " + id));
    }

    public Ubicacion cambiarLimpiable(int id, boolean limpiable) {
        Ubicacion existente = ubicacionRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Ubicación no encontrada con id: " + id));
        existente.setLimpiable(limpiable);
        return ubicacionRepo.save(existente);
    }

    public Ubicacion cambiarVentilado(int id, boolean ventilado) {
        Ubicacion existente = ubicacionRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Ubicación no encontrada con id: " + id));
        existente.setVentilado(ventilado);
        return ubicacionRepo.save(existente);
    }

    public Ubicacion cambiarCerrado(int id, boolean cerrado) {
        Ubicacion existente = ubicacionRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Ubicación no encontrada con id: " + id));
        existente.setCerrado(cerrado);
        return ubicacionRepo.save(existente);
    }
}
