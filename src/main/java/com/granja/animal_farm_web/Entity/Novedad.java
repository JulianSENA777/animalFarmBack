package com.granja.animal_farm_web.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.granja.animal_farm_web.Entity.Enums.tipoEvento;
import com.granja.animal_farm_web.Entity.Enums.gravedadNovedad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Data
@Table(name = "novedad")
public class Novedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "novedad_id")
    private Integer novedadId;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_evento")
    private tipoEvento tipo;

    @Column(name = "resumen_novedad", length = 100)
    private String resumenNovedad;

    @Enumerated(EnumType.STRING)
    @Column(name = "gravedad")
    private gravedadNovedad gravedad;

    @Column(name = "fecha_inicio_novedad")
    private LocalDate fechaInicioNovedad;

    @Column(name = "fecha_finalizacion_novedad")
    private LocalDate fechaFinalizacionNovedad;

    @Column(name = "estado_novedad")
    private Boolean estadoNovedad = true;

    @Column(name = "ultima_actualizacion_novedad")
    private LocalDateTime ultimaActualizacionNovedad;

    @Column(name = "foto_novedad", length = 255)
    private String fotoNovedad;

    @Column(name = "comentarios", columnDefinition = "TEXT")
    private String comentarios;


    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "historia_clinica_id")
    private HistoriaClinica historiaClinica;

    @ManyToMany
    @JoinTable(
        name = "novedad_parte_afectada",
        joinColumns = @JoinColumn(name = "novedad_id"),
        inverseJoinColumns = @JoinColumn(name = "parte_afectada_id")
    )
    private Set<ParteAfectada> partesAfectadas = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "novedad_desparasitacion",
        joinColumns = @JoinColumn(name = "novedad_id"),
        inverseJoinColumns = @JoinColumn(name = "desparasitacion_id")
    )
    private Set<Desparasitacion> desparasitaciones = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "novedad_vacuna",
        joinColumns = @JoinColumn(name = "novedad_id"),
        inverseJoinColumns = @JoinColumn(name = "vacuna_id")
    )
    private Set<Vacuna> vacunas = new HashSet<>();

    @ManyToMany(mappedBy = "novedades")
    private Set<Animal> animales = new HashSet<>();

    @OneToMany(mappedBy = "Novedad", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Novedad> novedades = new HashSet<>();
}
