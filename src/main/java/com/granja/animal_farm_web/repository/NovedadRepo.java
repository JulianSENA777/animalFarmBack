package com.granja.animal_farm_web.repository;

import com.granja.animal_farm_web.Entity.Novedad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NovedadRepo extends JpaRepository<Novedad, Integer> {
    // You can add custom query methods if needed
}

