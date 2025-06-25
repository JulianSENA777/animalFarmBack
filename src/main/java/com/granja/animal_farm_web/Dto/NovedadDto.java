package com.granja.animal_farm_web.Dto;

import com.granja.animal_farm_web.Entity.Enums.gravedadNovedad;
import com.granja.animal_farm_web.Entity.Enums.tipoEvento;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class NovedadDto {

    private Integer id;
    private tipoEvento tipo;
    private String resumenNovedad;
    private gravedadNovedad gravedad;
    private LocalDate fechaInicioNovedad;
    private LocalDate fechaFinalizacionNovedad;
    private Boolean estadoNovedad;
    private LocalDateTime ultimaActualizacionNovedad;
    private String fotoNovedad;
    private String comentarios;

    private Integer usuarioId;         // ID del usuario que crea la novedad
    private Integer historiaClinicaId; // ID de la historia clínica asociada
}

