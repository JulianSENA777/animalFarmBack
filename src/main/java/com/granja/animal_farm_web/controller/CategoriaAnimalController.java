package com.granja.animal_farm_web.controller;

import com.granja.animal_farm_web.Dto.CategoriaAnimalDto;
import com.granja.animal_farm_web.business.CategoriaAnimalBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/categorias-animal")
public class CategoriaAnimalController {

    @Autowired
    private CategoriaAnimalBusiness categoriaAnimalBusiness;

    @PostMapping("/addCategoria")
    public ResponseEntity<CategoriaAnimalDto> createCategoria(@RequestBody CategoriaAnimalDto categoriaDto) {
        CategoriaAnimalDto creado = categoriaAnimalBusiness.crearCategoriaAnimal(categoriaDto);
        return ResponseEntity.ok(creado);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarCategorias() {
        return ResponseEntity.ok(categoriaAnimalBusiness.listarCategoriasAnimales());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<CategoriaAnimalDto> actualizarCategoria(@PathVariable int id, @RequestBody CategoriaAnimalDto categoriaDto) {
        CategoriaAnimalDto actualizado = categoriaAnimalBusiness.actualizarCategoriaAnimal(id, categoriaDto);
        return ResponseEntity.ok(actualizado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaAnimalDto> obtenerCategoriaPorId(@PathVariable int id) {
        CategoriaAnimalDto categoria = categoriaAnimalBusiness.obtenerCategoriaAnimalPorId(id);
        return ResponseEntity.ok(categoria);
    }

}
