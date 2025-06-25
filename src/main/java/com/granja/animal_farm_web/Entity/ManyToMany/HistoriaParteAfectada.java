package com.granja.animal_farm_web.Entity.ManyToMany;

import com.granja.animal_farm_web.Entity.HistoriaClinica;
import com.granja.animal_farm_web.Entity.ParteAfectada;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Data
@Table(name = "partes_historias",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"historia_clinica_id", "parte_afectada_id"})}
)
public class HistoriaParteAfectada implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "historia_clinica_id", nullable = false)
    private HistoriaClinica historiaClinica;

    @ManyToOne
    @JoinColumn(name = "parte_afectada_id", nullable = false)
    private ParteAfectada parteAfectada;

    @Column(name = "fecha_de_incidente")
    private LocalDate fechaDeIncidente;

    @Column(name = "observaciones")
    private String observaciones;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoriaParteAfectada that = (HistoriaParteAfectada) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
