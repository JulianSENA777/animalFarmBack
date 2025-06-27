package com.granja.animal_farm_web.controller;

import com.granja.animal_farm_web.Dto.DesparasitacionDto;
import com.granja.animal_farm_web.business.DesparasitacionBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/desparasitaciones")
public class DesparasitacionController {

    @Autowired
    private DesparasitacionBusiness desparasitacionBusiness;

    @PostMapping("/addDesparasitacion")
    public ResponseEntity<DesparasitacionDto> createDesparasitacion(@RequestBody DesparasitacionDto desparasitacionDto) {
        DesparasitacionDto creado = desparasitacionBusiness.crearDesparasitacion(desparasitacionDto);
        return ResponseEntity.ok(creado);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarDesparasitaciones() {
        return ResponseEntity.ok(desparasitacionBusiness.listarDesparasitaciones());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<DesparasitacionDto> actualizarDesparasitacion(@PathVariable int id, @RequestBody DesparasitacionDto desparasitacionDto) {
        DesparasitacionDto actualizado = desparasitacionBusiness.actualizarDesparasitacion(id, desparasitacionDto);
        return ResponseEntity.ok(actualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DesparasitacionDto> obtenerDesparasitacionPorId(@PathVariable int id) {
        DesparasitacionDto desparasitacion = desparasitacionBusiness.obtenerDesparasitacionPorId(id);
        return ResponseEntity.ok(desparasitacion);
    }
}

