package com.granja.animal_farm_web.Entity;

import com.granja.animal_farm_web.Entity.Enums.estadoSaludAnimal; // Importa tu enum
import com.granja.animal_farm_web.Entity.Enums.sexoAnimal; // Importa tu enum
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Data
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id")
    private Integer animalId;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_salud")
    private estadoSaludAnimal estadoSalud;

    @Column(name = "nombre_animal", length = 100)
    private String nombreAnimal;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexo")
    private sexoAnimal sexo;

    @Column(name = "peso", precision = 8, scale = 2)
    private BigDecimal peso;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    @Column(name = "foto_animal", length = 255)
    private String fotoAnimal;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "estado_gestante")
    private boolean estadoGestante = false;


    @ManyToOne
    @JoinColumn(name = "ubicacion_id")
    private Ubicacion ubicacion;


    @ManyToOne
    @JoinColumn(name = "raza_id")
    private Raza raza;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;

    @Column(name = "estado")
    private boolean estado = true;

    @ManyToMany
    @JoinTable(
        name = "animal_novedad",
        joinColumns = @JoinColumn(name = "animal_id"),
        inverseJoinColumns = @JoinColumn(name = "novedad_id")
    )
    private java.util.Set<Novedad> novedades = new java.util.HashSet<>();
}