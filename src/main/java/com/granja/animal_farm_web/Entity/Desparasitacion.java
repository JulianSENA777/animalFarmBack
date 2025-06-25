package com.granja.animal_farm_web.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.granja.animal_farm_web.Entity.ManyToMany.HistoriaDesparasitacion;
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
@Table(name = "desparasitacion")
public class Desparasitacion {

    @Id // Marca 'desparasitacionId' como la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que el ID es auto-generado por la DB (SERIAL)
    @Column(name = "desparasitacion_id") // Mapea a la columna 'desparasitacion_id'
    private Integer desparasitacionId; // Siguiendo tu convención de IDs

    @Column(name = "tipo_parasito", length = 100) // Mapea a 'tipo_parasito', longitud 100
    private String tipoParasito;

    @Column(name = "medicamento_usado", length = 100) // Mapea a 'medicamento_usado', longitud 100
    private String medicamentoUsado;

    @Column(name = "observaciones", columnDefinition = "TEXT") // Mapea a 'observaciones', con tipo TEXT
    private String observaciones;

    @OneToMany(mappedBy = "desparasitacion")
    @JsonIgnore
    private Set<HistoriaDesparasitacion> historiaDesparasitaciones = new HashSet<>();
}
