package com.granja.animal_farm_web.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RazaDto {
    private Integer razaId;

    @NotNull(message = "El nombre de la raza es obligatorio")
    private String nombreRaza;

    private String observaciones;

    private CategoriaAnimalDto categoriaAnimalDto;
}

