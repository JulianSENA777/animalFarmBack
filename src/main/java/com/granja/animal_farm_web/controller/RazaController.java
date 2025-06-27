package com.granja.animal_farm_web.controller;

import com.granja.animal_farm_web.Dto.RazaDto;
import com.granja.animal_farm_web.business.RazaBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/razas")
public class RazaController {

    @Autowired
    private RazaBusiness razaBusiness;

    @PostMapping("/addRaza")
    public ResponseEntity<RazaDto> createRaza(@RequestBody RazaDto razaDto) {
        RazaDto creado = razaBusiness.crearRaza(razaDto);
        return ResponseEntity.ok(creado);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarRazas() {
        return ResponseEntity.ok(razaBusiness.listarRazas());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<RazaDto> actualizarRaza(@PathVariable int id, @RequestBody RazaDto razaDto) {
        RazaDto actualizado = razaBusiness.actualizarRaza(id, razaDto);
        return ResponseEntity.ok(actualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RazaDto> obtenerRazaPorId(@PathVariable int id) {
        RazaDto raza = razaBusiness.obtenerRazaPorId(id);
        return ResponseEntity.ok(raza);
    }
}
