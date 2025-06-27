package com.granja.animal_farm_web.controller;

import com.granja.animal_farm_web.Dto.UbicacionDto;
import com.granja.animal_farm_web.business.UbicacionBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ubicaciones")
public class UbicacionController {

    @Autowired
    private UbicacionBusiness ubicacionBusiness;

    @PostMapping("/addUbicacion")
    public ResponseEntity<UbicacionDto> createUbicacion(@RequestBody UbicacionDto ubicacionDto) {
        UbicacionDto creado = ubicacionBusiness.crearUbicacion(ubicacionDto);
        return ResponseEntity.ok(creado);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarUbicaciones() {
        return ResponseEntity.ok(ubicacionBusiness.listarUbicaciones());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<UbicacionDto> actualizarUbicacion(@PathVariable int id, @RequestBody UbicacionDto ubicacionDto) {
        UbicacionDto actualizado = ubicacionBusiness.actualizarUbicacion(id, ubicacionDto);
        return ResponseEntity.ok(actualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UbicacionDto> obtenerUbicacionPorId(@PathVariable int id) {
        UbicacionDto ubicacion = ubicacionBusiness.obtenerUbicacionPorId(id);
        return ResponseEntity.ok(ubicacion);
    }
}

