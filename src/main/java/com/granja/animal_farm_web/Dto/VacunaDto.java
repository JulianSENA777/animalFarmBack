package com.granja.animal_farm_web.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VacunaDto {
    private Integer vacunaId;

    @NotNull(message = "El nombre de la vacuna es obligatorio")
    private String nombreVacuna;

    @NotNull(message = "El tipo de vacuna es obligatorio")
    private String tipoVacuna;

    private String observaciones;
}

