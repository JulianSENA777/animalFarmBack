package com.granja.animal_farm_web.Services;

import com.granja.animal_farm_web.Entity.Vacuna;
import com.granja.animal_farm_web.exception.NotFoundException;
import com.granja.animal_farm_web.repository.VacunaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VacunaService {
    @Autowired
    private VacunaRepo vacunaRepo;

    public Vacuna crearVacuna(Vacuna vacuna) {
        return vacunaRepo.save(vacuna);
    }

    public List<Vacuna> listarVacunas() {
        return vacunaRepo.findAll();
    }

    public Vacuna actualizarVacuna(int id, Vacuna vacuna) {
        Vacuna existente = vacunaRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Vacuna no encontrada con id: " + id));
        vacuna.setVacunaId(id);
        return vacunaRepo.save(vacuna);
    }

    public Vacuna obtenerVacunaPorId(int id) {
        return vacunaRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Vacuna no encontrada con id: " + id));
    }
}
