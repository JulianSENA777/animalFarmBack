package com.granja.animal_farm_web.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Data
@Table(name = "categoria_animal")
public class CategoriaAnimal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_animal_id")
    private Integer categoriaAnimalId;
    @Column(name = "nombre_categoria", nullable = false, length = 100)
    private String nombreCategoria;
    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;

    @OneToMany(mappedBy = "categoriaAnimal", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Raza> razas = new HashSet<>();

public void addRaza(Raza raza) {
        this.razas.add(raza);
        raza.setCategoriaAnimal(this);
    }

    public void removeRaza(Raza raza) {
        this.razas.remove(raza);
        raza.setCategoriaAnimal(null);
    }
}