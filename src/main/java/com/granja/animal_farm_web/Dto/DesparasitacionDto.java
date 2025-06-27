package com.granja.animal_farm_web.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DesparasitacionDto {
    private Integer desparasitacionId;

    @NotNull(message = "El tipo de parásito es obligatorio")
    private String tipoParasito;

    @NotNull(message = "El medicamento usado es obligatorio")
    private String medicamentoUsado;

    private String observaciones;
}

