package com.granja.animal_farm_web.controller;

import com.granja.animal_farm_web.Dto.VacunaDto;
import com.granja.animal_farm_web.business.VacunaBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vacunas")
public class VacunaController {

    @Autowired
    private VacunaBusiness vacunaBusiness;

    @PostMapping("/addVacuna")
    public ResponseEntity<VacunaDto> createVacuna(@RequestBody VacunaDto vacunaDto) {
        VacunaDto creado = vacunaBusiness.crearVacuna(vacunaDto);
        return ResponseEntity.ok(creado);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarVacunas() {
        return ResponseEntity.ok(vacunaBusiness.listarVacunas());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<VacunaDto> actualizarVacuna(@PathVariable int id, @RequestBody VacunaDto vacunaDto) {
        VacunaDto actualizado = vacunaBusiness.actualizarVacuna(id, vacunaDto);
        return ResponseEntity.ok(actualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VacunaDto> obtenerVacunaPorId(@PathVariable int id) {
        VacunaDto vacuna = vacunaBusiness.obtenerVacunaPorId(id);
        return ResponseEntity.ok(vacuna);
    }
}

