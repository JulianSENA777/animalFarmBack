package com.granja.animal_farm_web.Entity; // Ajusta el paquete si es necesario para que coincida con tus otras entidades

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
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que el ID es auto-generado por la DB (SERIAL)
    @Column(name = "ubicacion_id")
    private Integer ubicacionId;

    @Column(name = "tipo_ubicacion", length = 100) // Mapea a 'tipo_ubicacion', longitud 100
    private String tipoUbicacion;

    @Column(name = "nombre_corral", length = 100)
    private String nombreCorral;

    @Column(name = "categoria", length = 50) // Mapea a 'categoria', longitud 50
    private String categoria;

    @Column(name = "limpiable") // Mapea a 'limpiable'
    private Boolean limpiable; // Usamos Boolean para permitir null si la columna no es NOT NULL en DB

    @Column(name = "ventilado") // Mapea a 'ventilado'
    private Boolean ventilado; // Usamos Boolean para permitir null

    @Column(name = "cerrado")
    private Boolean cerrado; // Usamos Boolean para permitir null

    @Column(name = "capacidad_maxima") // Mapea a 'capacidad_maxima'
    private Integer capacidadMaxima;

    @Column(name = "observaciones", columnDefinition = "TEXT") // Mapea a 'observaciones', con tipo TEXT
    private String observaciones;
}
