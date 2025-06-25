package com.granja.animal_farm_web.Entity.Enums;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum gravedadNovedad {
    baja("Baja"),     // Coincide con 'Baja' de la DB
    media("Media"),   // Coincide con 'Media' de la DB
    alta("Alta");     // Coincide con 'Alta' de la DB

    private final String descripcion;

    gravedadNovedad(String descripcion) {
        this.descripcion = descripcion;
    }

    @JsonValue // Indica que este método debe usarse para serializar el enum a JSON
    public String getDescripcion() {
        return descripcion;
    }

    @JsonCreator // Indica que este método debe usarse para deserializar JSON a un objeto enum
    public static gravedadNovedad fromString(String value) {
        for (gravedadNovedad gravedad : gravedadNovedad.values()) {
            // Compara tanto por el nombre de la constante (ahora en camelCase)
            // como por la descripción, ignorando mayúsculas/minúsculas.
            if (gravedad.name().equalsIgnoreCase(value) || gravedad.descripcion.equalsIgnoreCase(value)) {
                return gravedad;
            }
        }
        throw new IllegalArgumentException("Gravedad de novedad inválida: " + value);
    }
}
