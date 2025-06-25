package com.granja.animal_farm_web.Entity.Enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum generoUsuario {
    Femenino("Femenino"),
    Masculino("Masculino"),
    No_binario("No binario"),
    Otro("Otro");

    private final String value;

    generoUsuario(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static generoUsuario fromString(String value) {
        for (generoUsuario genero : generoUsuario.values()) {
            if (genero.value.equalsIgnoreCase(value) || genero.name().equalsIgnoreCase(value.replace(" ", "_"))) {
                return genero;
            }
        }
        throw new IllegalArgumentException("Género inválido: " + value);
    }
}