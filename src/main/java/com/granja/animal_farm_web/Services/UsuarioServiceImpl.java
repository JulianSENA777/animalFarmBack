package com.granja.animal_farm_web.Services;

import com.granja.animal_farm_web.Entity.Usuario;
import com.granja.animal_farm_web.repository.UserRepo;
import com.granja.animal_farm_web.exception.UsuarioNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return userRepo.save(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return userRepo.findAll();
    }

    @Override
    public Usuario actualizarUsuario(int id, Usuario usuario) {
        Usuario existente = userRepo.findById((long) id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario no encontrado con id: " + id));
        usuario.setUsuarioId(id);
        return userRepo.save(usuario);
    }

    @Override
    public Usuario desactivarUsuario(int id) {
        Usuario existente = userRepo.findById((long) id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario no encontrado con id: " + id));
        existente.setEstado(false);
        return userRepo.save(existente);
    }

    @Override
    public Usuario obtenerUsuarioPorId(int id) {
        return userRepo.findById((long) id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario no encontrado con id: " + id));
    }

    @Override
    public Usuario cambiarEstadoUsuario(int id, boolean estado) {
        Usuario existente = userRepo.findById((long) id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario no encontrado con id: " + id));
        existente.setEstado(estado);
        return userRepo.save(existente);
    }
}
