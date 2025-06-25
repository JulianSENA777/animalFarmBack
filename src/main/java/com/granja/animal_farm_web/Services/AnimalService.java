package com.granja.animal_farm_web.Services;

import com.granja.animal_farm_web.Entity.Animal;
import com.granja.animal_farm_web.repository.AnimalRepo;
import com.granja.animal_farm_web.exception.AnimalNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepo animalRepo;

    public Animal crearAnimal(Animal animal) {
        return animalRepo.save(animal);
    }

    public List<Animal> listarAnimales() {
        return animalRepo.findAll();
    }

    public Animal actualizarAnimal(int id, Animal animal) {
        Animal existente = animalRepo.findById(id)
                .orElseThrow(() -> new AnimalNotFoundException("Animal no encontrado con id: " + id));
        animal.setAnimalId(id);
        return animalRepo.save(animal);
    }

    public Animal desactivarAnimal(int id) {
        Animal existente = animalRepo.findById(id)
                .orElseThrow(() -> new AnimalNotFoundException("Animal no encontrado con id: " + id));
        existente.setEstado(false); // Desactiva el animal usando el campo boolean estado
        return animalRepo.save(existente);
    }

    public Animal obtenerAnimalPorId(int id) {
        return animalRepo.findById(id)
                .orElseThrow(() -> new AnimalNotFoundException("Animal no encontrado con id: " + id));
    }

    public Animal cambiarEstadoSalud(int id, com.granja.animal_farm_web.Entity.Enums.estadoSaludAnimal estadoSalud) {
        Animal existente = animalRepo.findById(id)
                .orElseThrow(() -> new AnimalNotFoundException("Animal no encontrado con id: " + id));
        existente.setEstadoSalud(estadoSalud);
        return animalRepo.save(existente);
    }

    public Animal cambiarEstadoAnimal(int id, boolean estado) {
        Animal existente = animalRepo.findById(id)
                .orElseThrow(() -> new AnimalNotFoundException("Animal no encontrado con id: " + id));
        existente.setEstado(estado);
        return animalRepo.save(existente);
    }
}
