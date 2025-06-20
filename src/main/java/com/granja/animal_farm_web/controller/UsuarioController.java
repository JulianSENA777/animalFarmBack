package com.granja.animal_farm_web.controller;
import com.granja.animal_farm_web.Entity.Usuario;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.granja.animal_farm_web.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.granja.animal_farm_web.Dto.UsuarioDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import jakarta.annotation.PostConstruct;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController { // Renombrado a mayúscula inicial

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/addUsuario")
    public ResponseEntity<?> createUsuario(@RequestBody UsuarioDto usuarioDto) {
        Usuario creado = usuarioService.crearUsuario(modelMapper.map(usuarioDto, Usuario.class));
        return ResponseEntity.ok(modelMapper.map(creado, UsuarioDto.class));
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarUsuarios() {
        return ResponseEntity.ok(
            usuarioService.listarUsuarios().stream().map(u -> modelMapper.map(u, UsuarioDto.class)).collect(Collectors.toList())
        );
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarUsuario(@PathVariable int id, @RequestBody UsuarioDto usuarioDto) {
        Usuario actualizado = usuarioService.actualizarUsuario(id, modelMapper.map(usuarioDto, Usuario.class));
        return ResponseEntity.ok(modelMapper.map(actualizado, UsuarioDto.class));
    }

    @PutMapping("/cambiar-estado/{id}")
    public ResponseEntity<?> cambiarEstadoUsuario(@PathVariable int id, @RequestParam boolean estado) {
        Usuario usuario = usuarioService.cambiarEstadoUsuario(id, estado);
        return ResponseEntity.ok(modelMapper.map(usuario, UsuarioDto.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerUsuarioPorId(@PathVariable int id) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
        return ResponseEntity.ok(modelMapper.map(usuario, UsuarioDto.class));
    }

}