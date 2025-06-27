package com.granja.animal_farm_web.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ParteAfectadaDto {
    private Integer parteAfectadaId;

    @NotNull(message = "El nombre de la parte afectada es obligatorio")
    private String nombreParteAfectada;

    @NotNull(message = "La categoría es obligatoria")
    private String categoria;

    private String observaciones;
}

