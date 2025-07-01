package com.granja.animal_farm_web.Dto;

import lombok.Data;
import java.util.Set;

@Data
public class HistoriaClinicaDto {
    private Integer historiaClinicaId;
    private String resumenHistoria;
    private String anamnesis;
    private String listaMaestrosDeProblemas;
    private String planDiagnostico;
    private String resultado;
    private Integer animalId;
    private Set<Integer> novedadesIds;
}

