package com.granja.animal_farm_web.controller;

import com.granja.animal_farm_web.Dto.AnimalDto;
import com.granja.animal_farm_web.Entity.Enums.estadoSaludAnimal;
import com.granja.animal_farm_web.business.AnimalBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/animales")
public class AnimalController {

    @Autowired
    private AnimalBusiness animalBusiness;

    @PostMapping("/addAnimal")
    public ResponseEntity<AnimalDto> createAnimal(@RequestBody AnimalDto animalDto) {
        AnimalDto creado = animalBusiness.crearAnimal(animalDto);
        return ResponseEntity.ok(creado);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarAnimales() {
        return ResponseEntity.ok(animalBusiness.listarAnimales());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<AnimalDto> actualizarAnimal(@PathVariable int id, @RequestBody AnimalDto animalDto) {
        AnimalDto actualizado = animalBusiness.actualizarAnimal(id, animalDto);
        return ResponseEntity.ok(actualizado);
    }

    @PatchMapping("/{id}/estado-salud")
    public ResponseEntity<AnimalDto> cambiarEstadoSalud(@PathVariable int id, @RequestBody Map<String, String> body) {
        estadoSaludAnimal estado = estadoSaludAnimal.valueOf(body.get("estadoSalud"));
        AnimalDto animal = animalBusiness.cambiarEstadoSalud(id, estado);
        return ResponseEntity.ok(animal);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalDto> obtenerAnimalPorId(@PathVariable int id) {
        AnimalDto animal = animalBusiness.obtenerAnimalPorId(id);
        return ResponseEntity.ok(animal);
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<AnimalDto> cambiarEstadoAnimal(@PathVariable int id, @RequestBody Map<String, Boolean> body) {
        boolean estado = body.get("estado");
        AnimalDto animal = animalBusiness.cambiarEstadoAnimal(id, estado);
        return ResponseEntity.ok(animal);
    }
}
