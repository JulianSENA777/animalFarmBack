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
@Table(name = "partes_afectadas")
public class ParteAfectada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parte_afectada_id")
    private Integer parteAfectadaId;

    @Column(name = "nombre_parte_afectada", nullable = false, length = 100)
    private String nombreParteAfectada;

    @Column(name = "categoria", length = 50)
    private String categoria;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;

    @ManyToMany(mappedBy = "partesAfectadas")
    private Set<Novedad> novedades = new HashSet<>();
}
