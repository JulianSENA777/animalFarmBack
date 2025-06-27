package com.granja.animal_farm_web.controller;

import com.granja.animal_farm_web.Dto.ParteAfectadaDto;
import com.granja.animal_farm_web.business.ParteAfectadaBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/partes-afectadas")
public class ParteAfectadaController {

    @Autowired
    private ParteAfectadaBusiness parteAfectadaBusiness;

    @PostMapping("/addParteAfectada")
    public ResponseEntity<ParteAfectadaDto> createParteAfectada(@RequestBody ParteAfectadaDto parteAfectadaDto) {
        ParteAfectadaDto creado = parteAfectadaBusiness.crearParteAfectada(parteAfectadaDto);
        return ResponseEntity.ok(creado);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarPartesAfectadas() {
        return ResponseEntity.ok(parteAfectadaBusiness.listarPartesAfectadas());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ParteAfectadaDto> actualizarParteAfectada(@PathVariable int id, @RequestBody ParteAfectadaDto parteAfectadaDto) {
        ParteAfectadaDto actualizado = parteAfectadaBusiness.actualizarParteAfectada(id, parteAfectadaDto);
        return ResponseEntity.ok(actualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParteAfectadaDto> obtenerParteAfectadaPorId(@PathVariable int id) {
        ParteAfectadaDto parteAfectada = parteAfectadaBusiness.obtenerParteAfectadaPorId(id);
        return ResponseEntity.ok(parteAfectada);
    }
}

