package com.granja.animal_farm_web.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "vacunas")
public class Vacuna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacuna_id")
    private Integer vacunaId;

    @Column(name = "nombre_vacuna", nullable = false, length = 100)
    private String nombreVacuna;

    @Column(name = "tipo_vacuna", length = 50)
    private String tipoVacuna;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;

    @ManyToMany(mappedBy = "vacunas")
    private Set<Novedad> novedades = new HashSet<>();
}
