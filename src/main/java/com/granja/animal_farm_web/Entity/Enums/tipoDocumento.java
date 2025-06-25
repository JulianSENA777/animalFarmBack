package com.granja.animal_farm_web.Entity.Enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum tipoDocumento {
    Cedula("CC"),
    CedulaExtranjeria("CE"),
    TarjetaIdentidad("TI"),
    Pasaporte("PP"),
    NIT("NIT");

    private final String descripcion;

    tipoDocumento(String descripcion) {
        this.descripcion = descripcion;
    }

    @JsonValue
    public String getDescripcion() {
        return descripcion;
    }

    @JsonCreator
    public static tipoDocumento fromString(String value) {
        for (tipoDocumento tipo : tipoDocumento.values()) {
            if (tipo.name().equalsIgnoreCase(value) || tipo.descripcion.equalsIgnoreCase(value)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de documento inválido: " + value);
    }
}