package com.sistema.GestionamientoExamenes.Services;

import com.sistema.GestionamientoExamenes.models.Rol;
import com.sistema.GestionamientoExamenes.models.Usuario;
import com.sistema.GestionamientoExamenes.models.UsuarioRol;
import java.util.Set;

/**
 * @author perez
 */
public interface ServiceUsuario {
    
    public Usuario guardarUsuario(Usuario usuario,Rol rol,UsuarioRol ur)
    throws Exception;
    
    public Usuario obtenerUsuario(String username);
    
    public void eliminarUsuario(Long id);
    
}
