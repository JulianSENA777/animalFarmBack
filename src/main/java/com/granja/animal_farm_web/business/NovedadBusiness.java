package com.granja.animal_farm_web.business;

import com.granja.animal_farm_web.Entity.Novedad;
import com.granja.animal_farm_web.Entity.Enums.tipoEvento;
import com.granja.animal_farm_web.exception.IllegalArgumentException;
import com.granja.animal_farm_web.Services.NovedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NovedadBusiness {
    @Autowired
    private NovedadService novedadService;

    public Novedad crearNovedad(Novedad novedad) {
        validarRelacionesPorTipo(novedad);
        return novedadService.crearNovedad(novedad);
    }

    private void validarRelacionesPorTipo(Novedad novedad) {
        tipoEvento tipo = novedad.getTipo();
        switch (tipo) {
            case TRASLADO:
                if ((novedad.getUbicaciones() == null || novedad.getUbicaciones().isEmpty()) ||
                    (novedad.getVacunas() != null && !novedad.getVacunas().isEmpty()) ||
                    (novedad.getDesparasitaciones() != null && !novedad.getDesparasitaciones().isEmpty()) ||
                    (novedad.getPartesAfectadas() != null && !novedad.getPartesAfectadas().isEmpty())) {
                    throw new IllegalArgumentException("Para TRASLADO solo se puede asociar ubicaciones y no otras relaciones");
                }
                break;
            case VACUNACION:
                if ((novedad.getVacunas() == null || novedad.getVacunas().isEmpty()) ||
                    (novedad.getUbicaciones() != null && !novedad.getUbicaciones().isEmpty()) ||
                    (novedad.getDesparasitaciones() != null && !novedad.getDesparasitaciones().isEmpty()) ||
                    (novedad.getPartesAfectadas() != null && !novedad.getPartesAfectadas().isEmpty())) {
                    throw new IllegalArgumentException("Para VACUNACION solo se puede asociar vacunas y no otras relaciones");
                }
                break;
            case DESPARASITACION:
                if ((novedad.getDesparasitaciones() == null || novedad.getDesparasitaciones().isEmpty()) ||
                    (novedad.getUbicaciones() != null && !novedad.getUbicaciones().isEmpty()) ||
                    (novedad.getVacunas() != null && !novedad.getVacunas().isEmpty()) ||
                    (novedad.getPartesAfectadas() != null && !novedad.getPartesAfectadas().isEmpty())) {
                    throw new IllegalArgumentException("Para DESPARASITACION solo se puede asociar desparasitaciones y no otras relaciones");
                }
                break;
            case PARTE_AFECTADA:
                if ((novedad.getPartesAfectadas() == null || novedad.getPartesAfectadas().isEmpty()) ||
                    (novedad.getUbicaciones() != null && !novedad.getUbicaciones().isEmpty()) ||
                    (novedad.getVacunas() != null && !novedad.getVacunas().isEmpty()) ||
                    (novedad.getDesparasitaciones() != null && !novedad.getDesparasitaciones().isEmpty())) {
                    throw new IllegalArgumentException("Para PARTE_AFECTADA solo se puede asociar partes afectadas y no otras relaciones");
                }
                break;
            // Puedes agregar más casos según tus enums
            default:
                // Si el tipo no requiere relaciones, asegúrate de que todas estén vacías
                if ((novedad.getUbicaciones() != null && !novedad.getUbicaciones().isEmpty()) ||
                    (novedad.getVacunas() != null && !novedad.getVacunas().isEmpty()) ||
                    (novedad.getDesparasitaciones() != null && !novedad.getDesparasitaciones().isEmpty()) ||
                    (novedad.getPartesAfectadas() != null && !novedad.getPartesAfectadas().isEmpty())) {
                    throw new IllegalArgumentException("El tipo de novedad seleccionado no debe tener relaciones asociadas");
                }
        }
    }
}

