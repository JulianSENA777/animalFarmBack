package com.granja.animal_farm_web.Entity.Enums;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum gravedadNovedad {
    baja("Baja"),
    media("Media"),
    alta("Alta");

    private final String descripcion;

    gravedadNovedad(String descripcion) {
        this.descripcion = descripcion;
    }

    @JsonValue
    public String getDescripcion() {
        return descripcion;
    }

    @JsonCreator
    public static gravedadNovedad fromString(String value) {
        for (gravedadNovedad gravedad : gravedadNovedad.values()) {

            if (gravedad.name().equalsIgnoreCase(value) || gravedad.descripcion.equalsIgnoreCase(value)) {
                return gravedad;
            }
        }
        throw new IllegalArgumentException("Gravedad de novedad inválida: " + value);
    }
}
