package com.granja.animal_farm_web.Services;

import com.granja.animal_farm_web.Entity.Usuario;
import java.util.List;

public interface UsuarioService {
    Usuario crearUsuario(Usuario usuario);
    List<Usuario> listarUsuarios();
    Usuario actualizarUsuario(int id, Usuario usuario);
    Usuario desactivarUsuario(int id);
    Usuario obtenerUsuarioPorId(int id);
    Usuario cambiarEstadoUsuario(int id, boolean estado);
}
