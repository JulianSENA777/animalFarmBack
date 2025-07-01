package com.granja.animal_farm_web.controller;

import com.granja.animal_farm_web.Entity.HistoriaClinica;
import com.granja.animal_farm_web.Services.HistoriaClinicaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/historias-clinicas")
public class HistoriaClinicaController {

    @Autowired
    private HistoriaClinicaService historiaClinicaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<HistoriaClinica> crearHistoriaClinica(@RequestBody HistoriaClinica historiaClinica) {
        HistoriaClinica creada = historiaClinicaService.crearHistoriaClinica(historiaClinica);
        return ResponseEntity.ok(creada);
    }

    @GetMapping
    public ResponseEntity<List<HistoriaClinica>> listarHistoriasClinicas() {
        List<HistoriaClinica> lista = historiaClinicaService.listarHistoriasClinicas();
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<HistoriaClinica> actualizarHistoriaClinica(@PathVariable int id, @RequestBody HistoriaClinica historiaClinica) {
        HistoriaClinica actualizada = historiaClinicaService.actualizarHistoriaClinica(id, historiaClinica);
        return ResponseEntity.ok(actualizada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoriaClinica> obtenerHistoriaClinicaPorId(@PathVariable int id) {
        HistoriaClinica historia = historiaClinicaService.obtenerHistoriaClinicaPorId(id);
        return ResponseEntity.ok(historia);
    }
}

