package com.granja.animal_farm_web.controller;

import com.granja.animal_farm_web.Dto.NovedadDto;
import com.granja.animal_farm_web.Services.UsuarioService;
import com.granja.animal_farm_web.business.NovedadBusiness;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/novedades")
public class NovedadController {

    @Autowired
    private NovedadBusiness novedadBusiness;

    @PostMapping
    public ResponseEntity<NovedadDto> crearNovedad(@RequestBody NovedadDto dto) {
        NovedadDto guardada = novedadBusiness.crearNovedad(dto);
        return ResponseEntity.ok(guardada);
    }

    @GetMapping
    public ResponseEntity<List<NovedadDto>> listarTodas() {
        List<NovedadDto> lista = novedadBusiness.listarNovedades();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NovedadDto> obtenerPorId(@PathVariable Integer id) {
        NovedadDto novedad = novedadBusiness.obtenerNovedadPorId(id);
        return ResponseEntity.ok(novedad);
    }
}
