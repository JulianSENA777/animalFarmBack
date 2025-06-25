package com.granja.animal_farm_web.Entity.Enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum sexoAnimal {
    macho("Macho"),
    hembra("Hembra");

    private final String descripcion;

    sexoAnimal(String descripcion) {
        this.descripcion = descripcion;
    }

    @JsonValue
    public String getDescripcion() {
        return descripcion;
    }

    @JsonCreator
    public static sexoAnimal fromString(String value) {
        for (sexoAnimal sexo : sexoAnimal.values()) {
            if (sexo.name().equalsIgnoreCase(value) || sexo.descripcion.equalsIgnoreCase(value)) {
                return sexo;
            }
        }
        throw new IllegalArgumentException("Sexo animal inválido: " + value);
    }
}