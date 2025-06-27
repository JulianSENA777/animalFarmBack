package com.granja.animal_farm_web.Services;

import com.granja.animal_farm_web.Entity.CategoriaAnimal;
import com.granja.animal_farm_web.repository.CategoriaAnimalRepo;
import com.granja.animal_farm_web.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoriaAnimalService {
    @Autowired
    private CategoriaAnimalRepo categoriaAnimalRepo;

    public CategoriaAnimal crearCategoriaAnimal(CategoriaAnimal CategoriaAnimal) {
        return categoriaAnimalRepo.save(CategoriaAnimal);
    }

    public List<CategoriaAnimal> listarCategoriaAnimal() {
        return categoriaAnimalRepo.findAll();
    }

    public CategoriaAnimal actualizarCategoriaAnimal(int id, CategoriaAnimal categoriaAnimal) {
        CategoriaAnimal existente = categoriaAnimalRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoria animal no encontrado con id: " + id));
        categoriaAnimal.setCategoriaAnimalId(id);
        return categoriaAnimalRepo.save(categoriaAnimal);
    }

    public CategoriaAnimal obtenerCategoriaAnimalId(int id) {
        return categoriaAnimalRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoria animal no encontrado con id: " + id));
    }


}
