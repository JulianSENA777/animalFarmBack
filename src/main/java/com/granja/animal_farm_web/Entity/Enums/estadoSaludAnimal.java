package com.granja.animal_farm_web.Entity.Enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum estadoSaludAnimal {
    estable("Estable"),
    inestable("Inestable"),
    critico("Crítico"),
    postoperatorio("Postoperatorio"),
    enObservacion("En observación"),
    hospitalizado("Hospitalizado"),
    enCuarentena("En cuarentena");

    private final String descripcion;

    estadoSaludAnimal(String descripcion) {
        this.descripcion = descripcion;
    }

    @JsonValue
    public String getDescripcion() {
        return descripcion;
    }

    @JsonCreator
    public static estadoSaludAnimal fromString(String value) {
        for (estadoSaludAnimal estado : estadoSaludAnimal.values()) {
            if (estado.name().equalsIgnoreCase(value) || estado.descripcion.equalsIgnoreCase(value)) {
                return estado;
            }
        }
        throw new IllegalArgumentException("Estado de salud animal inválido: " + value);
    }
}
