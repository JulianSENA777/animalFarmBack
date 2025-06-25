package com.granja.animal_farm_web.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Data
@Table(name = "raza") // Mapea la clase a la tabla 'raza'
public class Raza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "raza_id")
    private Integer razaId;

    @Column(name = "nombre_raza", nullable = false, length = 100)
    private String nombreRaza;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;


    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaAnimal categoriaAnimal;

}