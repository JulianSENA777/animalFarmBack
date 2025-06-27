package com.granja.animal_farm_web.repository;

import com.granja.animal_farm_web.Entity.Vacuna;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacunaRepo extends JpaRepository<Vacuna, Integer> {
    // You can add custom query methods if needed
}

