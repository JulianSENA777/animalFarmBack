package com.granja.animal_farm_web.Entity.Enums;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum tipoEvento {
    chequeoRutinario("Chequeo Rutinario"),
    vacunacion("Vacunación"),
    tratamientoMedico("Tratamiento Médico"),
    cirugia("Cirugía"),
    revisionPostoperatoria("Revisión Postoperatoria"),
    observacion("Observación"),
    aislamiento("Aislamiento"),
    cambioDeDieta("Cambio de Dieta"),
    enfermedad("Enfermedad"),
    infeccion("Infección"),
    lesion("Lesión"),
    parasitacion("Parasitación"),
    porDiagnosticar("Por Diagnosticar"),
    evaluacionEtologica("Evaluación Etológica"),
    nacimiento("Nacimiento"),
    fallecimiento("Fallecimiento"),
    ingreso("Ingreso"),
    traslado("Traslado"),
    reubicacionDefinitiva("Reubicación Definitiva"),
    deAlta("De Alta"),
    recuperacion("Recuperación");

    private final String descripcion;

    tipoEvento(String descripcion) {
        this.descripcion = descripcion;
    }

    @JsonValue // Indica que este método debe usarse para serializar el enum a JSON
    public String getDescripcion() {
        return descripcion;
    }

    @JsonCreator
    public static tipoEvento fromString(String value) {
        for (tipoEvento tipo : tipoEvento.values()) {
            if (tipo.name().equalsIgnoreCase(value) || tipo.descripcion.equalsIgnoreCase(value)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo de evento inválido: " + value);
    }
}
