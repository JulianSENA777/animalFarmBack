package com.granja.animal_farm_web.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Data
@Table(name = "ubicacion")
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ubicacion_id")
    private Integer ubicacionId;

    @Column(name = "tipo_ubicacion", length = 100)
    private String tipoUbicacion;

    @Column(name = "nombre_corral", length = 100)
    private String nombreCorral;

    @Column(name = "categoria", length = 50)
    private String categoria;

    @Column(name = "limpiable")
    private Boolean limpiable;

    @Column(name = "ventilado")
    private Boolean ventilado;

    @Column(name = "cerrado")
    private Boolean cerrado;

    @Column(name = "capacidad_maxima")
    private Integer capacidadMaxima;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;

    @ManyToMany(mappedBy = "ubicaciones")
    private java.util.Set<Novedad> novedades = new java.util.HashSet<>();
}
