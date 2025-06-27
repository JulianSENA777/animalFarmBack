package com.granja.animal_farm_web.Services;

import com.granja.animal_farm_web.Entity.Raza;
import com.granja.animal_farm_web.exception.NotFoundException;
import com.granja.animal_farm_web.repository.RazaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RazaService {
    @Autowired
    private RazaRepo razaRepo;

    public Raza crearRaza(Raza raza) {
        return razaRepo.save(raza);
    }

    public List<Raza> listarRaza() {
        return razaRepo.findAll();
    }

    public Raza actualizarRaza(int id, Raza raza) {
        Raza existente = razaRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Raza no encontrada con id: " + id));
        raza.setRazaId(id);
        return razaRepo.save(raza);
    }

    public Raza obtenerRazaId(int id) {
        return razaRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Raza no encontrada con id: " + id));
    }
}
