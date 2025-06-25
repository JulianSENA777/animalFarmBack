package com.granja.animal_farm_web.Services;

import com.granja.animal_farm_web.Entity.Novedad;
import java.util.List;

public interface NovedadService {
    Novedad guardarNovedad(Novedad novedad);
    List<Novedad> listarTodas();
    List<Novedad> listarPorHistoriaClinica(Integer historiaClinicaId);
}