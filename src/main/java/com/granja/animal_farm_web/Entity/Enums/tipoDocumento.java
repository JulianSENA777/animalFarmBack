package com.granja.animal_farm_web.Entity.Enums;


public enum tipoDocumento {
    Cedula("Cédula de Ciudadanía"),
    CedulaExtranjeria("Cédula de Extranjería"),
    TarjetaIdentidad("Tarjeta de Identidad"),
    Pasaporte("Pasaporte"),
    NIT("NIT");

    private final String descripcion;

    tipoDocumento(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}