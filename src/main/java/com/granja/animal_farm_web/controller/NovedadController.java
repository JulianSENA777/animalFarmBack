//package com.granja.animal_farm_web.controller;
//
//import com.granja.animal_farm_web.Dto.NovedadDto;
//import com.granja.animal_farm_web.Entity.HistoriaClinica;
//import com.granja.animal_farm_web.Entity.Novedad;
//import com.granja.animal_farm_web.Entity.Usuario;
//import com.granja.animal_farm_web.Services.HistoriaClinicaService;
//import com.granja.animal_farm_web.Services.NovedadService;
//import com.granja.animal_farm_web.Services.UsuarioService;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/novedades")
//public class NovedadController {
//
//    @Autowired
//    private NovedadService novedadService;
//
//    @Autowired
//    private UsuarioService usuarioService;
//
//    @Autowired
//    private HistoriaClinicaService historiaService;
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//    @PostMapping
//    public ResponseEntity<NovedadDto> crearNovedad(@RequestBody NovedadDto dto) {
//        Usuario usuario = usuarioService.obtenerUsuarioPorId(dto.getUsuarioId());
//        HistoriaClinica historia = historiaService.obtenerPorId(dto.getHistoriaClinicaId());
//
//        Novedad novedad = modelMapper.map(dto, Novedad.class);
//        novedad.setUsuario(usuario);
//        novedad.setHistoriaClinica(historia);
//
//        Novedad guardada = novedadService.guardarNovedad(novedad);
//        return ResponseEntity.ok(modelMapper.map(guardada, NovedadDto.class));
//    }
//
//    @GetMapping
//    public ResponseEntity<List<NovedadDto>> listarTodas() {
//        List<NovedadDto> lista = novedadService.listarTodas()
//                .stream()
//                .map(n -> modelMapper.map(n, NovedadDto.class))
//                .collect(Collectors.toList());
//        return ResponseEntity.ok(lista);
//    }
//
//    @GetMapping("/historia/{id}")
//    public ResponseEntity<List<NovedadDto>> listarPorHistoria(@PathVariable Integer id) {
//        List<NovedadDto> lista = novedadService.listarPorHistoriaClinica(id)
//                .stream()
//                .map(n -> modelMapper.map(n, NovedadDto.class))
//                .collect(Collectors.toList());
//        return ResponseEntity.ok(lista);
//    }
//}
