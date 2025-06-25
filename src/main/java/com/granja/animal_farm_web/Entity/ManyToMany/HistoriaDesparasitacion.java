package com.granja.animal_farm_web.Entity.ManyToMany;

import com.granja.animal_farm_web.Entity.HistoriaClinica;
import com.granja.animal_farm_web.Entity.Desparasitacion;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Data
@Table(name = "historia_desparasitacion",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"historia_clinica_id", "desparasitacion_id"})}
)
public class HistoriaDesparasitacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "historia_clinica_id", nullable = false)
    private HistoriaClinica historiaClinica;

    @ManyToOne
    @JoinColumn(name = "desparasitacion_id", nullable = false)
    private Desparasitacion desparasitacion;

    @Column(name = "fecha_desparasitacion")
    private LocalDate fechaDesparasitacion;

    @Column(name = "observaciones")
    private String observaciones;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoriaDesparasitacion that = (HistoriaDesparasitacion) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

