package com.granja.animal_farm_web.repository;

import com.granja.animal_farm_web.Entity.CategoriaAnimal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaAnimalRepo extends JpaRepository<CategoriaAnimal, Integer> {
//    boolean existsByCategoriaAnimal(String CategoriaAnimal);
}

