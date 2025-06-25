package com.granja.animal_farm_web.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.granja.animal_farm_web.Entity.ManyToMany.HistoriaParteAfectada;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter // Genera setters para todos los campos
@Getter // Genera getters para todos los campos
@Entity // Marca esta clase como una entidad JPA
@Data // Añade funcionalidades de Lombok
@Table(name = "partes_afectadas") // Mapea la clase a la tabla 'partes_afectadas'
public class ParteAfectada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que el ID es auto-generado por la DB (SERIAL)
    @Column(name = "parte_afectada_id") // Mapea a la columna 'parte_afectada_id'
    private Integer parteAfectadaId; // Siguiendo tu convención de IDs

    @Column(name = "nombre_parte_afectada", nullable = false, length = 100) // Mapea a 'nombre_parte_afectada', no nulo, longitud 100
    private String nombreParteAfectada;

    @Column(name = "categoria", length = 50) // Mapea a 'categoria', longitud 50
    private String categoria;

    @Column(name = "observaciones", columnDefinition = "TEXT") // Mapea a 'observaciones', con tipo TEXT
    private String observaciones;

    @OneToMany(mappedBy = "parteAfectada")
    @JsonIgnore
    private Set<HistoriaParteAfectada> historiaPartesAfectadas = new HashSet<>();
}
