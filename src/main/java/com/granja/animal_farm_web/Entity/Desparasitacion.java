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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "desparasitacion_id")
    private Integer desparasitacionId;

    @Column(name = "tipo_parasito", length = 100)
    private String tipoParasito;

    @Column(name = "medicamento_usado", length = 100)
    private String medicamentoUsado;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;

    @OneToMany(mappedBy = "desparasitacion")
    @JsonIgnore
    private Set<HistoriaDesparasitacion> historiaDesparasitaciones = new HashSet<>();
}
