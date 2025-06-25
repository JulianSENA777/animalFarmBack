package com.granja.animal_farm_web.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.granja.animal_farm_web.Dto.UsuarioDto;
import com.granja.animal_farm_web.business.UsuarioBusiness;

import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioBusiness usuarioBusiness;

    @PostMapping("/addUsuario")
    public ResponseEntity<?> createUsuario(@RequestBody UsuarioDto usuarioDto) {
        UsuarioDto creado = usuarioBusiness.crearUsuario(usuarioDto);
        return ResponseEntity.ok(creado);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarUsuarios() {
        return ResponseEntity.ok(usuarioBusiness.listarUsuarios());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarUsuario(@PathVariable int id, @RequestBody UsuarioDto usuarioDto) {
        UsuarioDto actualizado = usuarioBusiness.actualizarUsuario(id, usuarioDto);
        return ResponseEntity.ok(actualizado);
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<UsuarioDto> cambiarEstadoUsuario(@PathVariable int id, @RequestBody Map<String, Boolean> body) {
        boolean estado = body.get("estado");
        UsuarioDto usuario = usuarioBusiness.cambiarEstadoUsuario(id, estado);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerUsuarioPorId(@PathVariable int id) {
        UsuarioDto usuario = usuarioBusiness.obtenerUsuarioPorId(id);
        return ResponseEntity.ok(usuario);
    }

}