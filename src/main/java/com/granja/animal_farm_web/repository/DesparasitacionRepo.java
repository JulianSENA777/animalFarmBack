package com.granja.animal_farm_web.repository;

import com.granja.animal_farm_web.Entity.Desparasitacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesparasitacionRepo extends JpaRepository<Desparasitacion, Integer> {
    // Custom queries if needed
}

