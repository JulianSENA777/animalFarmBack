package com.granja.animal_farm_web.business;

import com.granja.animal_farm_web.Entity.Usuario;
import com.granja.animal_farm_web.Dto.UsuarioDto;
import com.granja.animal_farm_web.Services.UsuarioService;
import com.granja.animal_farm_web.exception.UsuarioNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UsuarioBusiness {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ModelMapper modelMapper;

    public UsuarioDto crearUsuario(UsuarioDto usuarioDto) {
        usuarioDto.setUsuarioId(null);
        Usuario usuario = modelMapper.map(usuarioDto, Usuario.class);
        usuario.setUsuarioId(null);
        validarCoherenciaDatos(usuarioDto);
        Usuario creado = usuarioService.crearUsuario(usuario);
        return modelMapper.map(creado, UsuarioDto.class);
    }

    private void validarCoherenciaDatos(UsuarioDto usuarioDto) {
        // Validar coherencia entre edad y fecha de nacimiento
        if (usuarioDto.getFechaDeNacimiento() != null && usuarioDto.getEdad() != null) {
            int edadCalculada = java.time.Period.between(usuarioDto.getFechaDeNacimiento(), java.time.LocalDate.now()).getYears();
            if (!usuarioDto.getEdad().equals(edadCalculada)) {
                throw new IllegalArgumentException("La edad no coincide con la fecha de nacimiento");
            }
        }
        // Validar coherencia entre tipo de documento y número de identificación
        if (usuarioDto.getTipoDocumento() != null && usuarioDto.getNumeroIdentificacion() != null) {
            if (usuarioDto.getTipoDocumento().name().equalsIgnoreCase("CC") && usuarioDto.getNumeroIdentificacion().length() != 10) {
                throw new IllegalArgumentException("El número de identificación para CC debe tener 10 dígitos");
            }
            // Agrega aquí más reglas según el tipo de documento
        }
    }

    public List<UsuarioDto> listarUsuarios() {
        return usuarioService.listarUsuarios().stream()
            .map(usuario -> modelMapper.map(usuario, UsuarioDto.class))
            .collect(java.util.stream.Collectors.toList());
    }

    private Usuario validarExistenciaUsuario(int id) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
        if (usuario == null) {
            throw new UsuarioNotFoundException("Usuario no encontrado con id: " + id);
        }
        return usuario;
    }

    public UsuarioDto actualizarUsuario(int id, UsuarioDto usuarioDto) {
        validarExistenciaUsuario(id);
        validarCoherenciaDatos(usuarioDto);
        Usuario usuario = modelMapper.map(usuarioDto, Usuario.class);
        Usuario actualizado = usuarioService.actualizarUsuario(id, usuario);
        return modelMapper.map(actualizado, UsuarioDto.class);
    }

    public UsuarioDto desactivarUsuario(int id) {
        validarExistenciaUsuario(id);
        Usuario desactivado = usuarioService.desactivarUsuario(id);
        return modelMapper.map(desactivado, UsuarioDto.class);
    }

    public UsuarioDto obtenerUsuarioPorId(int id) {
        Usuario usuario = validarExistenciaUsuario(id);
        return modelMapper.map(usuario, UsuarioDto.class);
    }

    public UsuarioDto cambiarEstadoUsuario(int id, boolean estado) {
        validarExistenciaUsuario(id);
        Usuario usuario = usuarioService.cambiarEstadoUsuario(id, estado);
        return modelMapper.map(usuario, UsuarioDto.class);
    }
}
