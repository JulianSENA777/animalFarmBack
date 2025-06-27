package com.granja.animal_farm_web.repository;

import com.granja.animal_farm_web.Entity.Raza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RazaRepo extends JpaRepository<Raza, Integer> {
    // You can add custom query methods if needed
}

