package com.granja.animal_farm_web.repository;

import com.granja.animal_farm_web.Entity.ParteAfectada;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParteAfectadaRepo extends JpaRepository<ParteAfectada, Integer> {
    // Custom queries if needed
}

