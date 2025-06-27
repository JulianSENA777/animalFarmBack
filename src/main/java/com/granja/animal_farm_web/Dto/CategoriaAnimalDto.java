package com.granja.animal_farm_web.Dto;

import jakarta.validation.constraints.*;
import lombok.Data;

    @Data
    public class CategoriaAnimalDto {
        private Integer categoriaAnimalId;

        @NotNull(message = "El nombre de la categoría es obligatorio")
        private String nombreCategoria;


    }


