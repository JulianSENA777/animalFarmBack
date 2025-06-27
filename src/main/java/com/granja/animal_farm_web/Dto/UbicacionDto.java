package com.granja.animal_farm_web.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UbicacionDto {
    private Integer ubicacionId;

    @NotNull(message = "El tipo de ubicación es obligatorio")
    private String tipoUbicacion;

    @NotNull(message = "El nombre del corral es obligatorio")
    private String nombreCorral;

    @NotNull(message = "La categoría es obligatoria")
    private String categoria;

    @NotNull(message = "El campo 'limpiable' es obligatorio")
    private Boolean limpiable;

    @NotNull(message = "El campo 'ventilado' es obligatorio")
    private Boolean ventilado;

    @NotNull(message = "El campo 'cerrado' es obligatorio")
    private Boolean cerrado;

    @NotNull(message = "La capacidad máxima es obligatoria")
    private Integer capacidadMaxima;

    private String observaciones;
}
