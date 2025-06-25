package com.granja.animal_farm_web.Services;

import com.granja.animal_farm_web.Entity.Usuario;
import com.granja.animal_farm_web.repository.UserRepo;
import com.granja.animal_farm_web.exception.UsuarioNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UserRepo userRepo;

    public Usuario crearUsuario(Usuario usuario) {
        return userRepo.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return userRepo.findAll();
    }

    public Usuario actualizarUsuario(int id, Usuario usuario) {
        Usuario existente = userRepo.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario no encontrado con id: " + id));
        usuario.setUsuarioId(id);
        return userRepo.save(usuario);
    }

    public Usuario desactivarUsuario(int id) {
        Usuario existente = userRepo.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario no encontrado con id: " + id));
        existente.setEstado(false);
        return userRepo.save(existente);
    }

    public Usuario obtenerUsuarioPorId(int id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario no encontrado con id: " + id));
    }

    public Usuario cambiarEstadoUsuario(int id, boolean estado) {
        Usuario existente = userRepo.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario no encontrado con id: " + id));
        existente.setEstado(estado);
        return userRepo.save(existente);
    }
}
