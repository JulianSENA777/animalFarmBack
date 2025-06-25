package com.granja.animal_farm_web.repository;

import com.granja.animal_farm_web.Entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepo extends JpaRepository<Animal, Integer> {
    boolean existsByNombreAnimal(String nombreAnimal);
}

