package com.granja.animal_farm_web.Entity.ManyToMany;

import com.granja.animal_farm_web.Entity.HistoriaClinica;
import com.granja.animal_farm_web.Entity.Vacuna;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Data
@Table(name = "historia_vacunas",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"historia_clinica_id", "vacuna_id"})}
)
public class HistoriaVacuna implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "historia_clinica_id", nullable = false)
    private HistoriaClinica historiaClinica;

    @ManyToOne
    @JoinColumn(name = "vacuna_id", nullable = false)
    private Vacuna vacuna;

    @Column(name = "fecha_vacunacion")
    private LocalDate fechaVacunacion;

    @Column(name = "observaciones")
    private String observaciones;

    @PrePersist
    public void prePersist() {
        if (fechaVacunacion == null) {
            fechaVacunacion = LocalDate.now();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoriaVacuna that = (HistoriaVacuna) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
