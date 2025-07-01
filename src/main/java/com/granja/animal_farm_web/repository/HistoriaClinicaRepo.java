package com.granja.animal_farm_web.repository;

import com.granja.animal_farm_web.Entity.HistoriaClinica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoriaClinicaRepo extends JpaRepository<HistoriaClinica, Integer> {
    // You can add custom query methods if needed
}

