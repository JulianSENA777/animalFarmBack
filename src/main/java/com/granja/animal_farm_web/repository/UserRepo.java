package com.granja.animal_farm_web.repository;
import com.granja.animal_farm_web.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository <Usuario, Long> {
    // Additional query methods can be defined here if needed
}
