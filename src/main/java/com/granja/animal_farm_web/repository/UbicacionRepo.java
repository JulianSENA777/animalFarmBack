package com.granja.animal_farm_web.repository;

import com.granja.animal_farm_web.Entity.Ubicacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UbicacionRepo extends JpaRepository<Ubicacion, Integer> {
    // You can add custom query methods if needed
}

