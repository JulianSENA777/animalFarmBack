package com.granja.animal_farm_web.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.granja.animal_farm_web.Entity.ManyToMany.HistoriaVacuna;
import com.granja.animal_farm_web.Entity.ManyToMany.HistoriaParteAfectada;
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
@Table(name = "historia_clinica")
public class HistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que el ID es auto-generado por la DB (SERIAL)
    @Column(name = "historia_clinica_id")
    private Integer historiaClinicaId;

    @Column(name = "resumen_historia", length = 500)
    private String resumenHistoria;

    @Column(name = "anamnesis", columnDefinition = "TEXT")
    private String anamnesis;

    @Column(name = "lista_maestros_de_problemas", columnDefinition = "TEXT")
    private String listaMaestrosDeProblemas;

    @Column(name = "plan_diagnostico", columnDefinition = "TEXT")
    private String planDiagnostico;

    @Column(name = "resultado", columnDefinition = "TEXT")
    private String resultado;


    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "historia_usuario",
            joinColumns = @JoinColumn(name = "historia_clinica_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private Set<Usuario> usuarios = new HashSet<>();

    @OneToMany(mappedBy = "historiaClinica")
    @JsonIgnore
    private Set<HistoriaVacuna> historiaVacunas = new HashSet<>();

    @OneToMany(mappedBy = "historiaClinica")
    @JsonIgnore
    private Set<HistoriaParteAfectada> historiaPartesAfectadas = new HashSet<>();

    @OneToMany(mappedBy = "historiaClinica")
    @JsonIgnore
    private Set<HistoriaDesparasitacion> historiaDesparasitaciones = new HashSet<>();
}
