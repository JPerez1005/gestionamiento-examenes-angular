package com.sistema.GestionamientoExamenes.Services.Impl;

import com.sistema.GestionamientoExamenes.Services.ServiceUsuario;
import com.sistema.GestionamientoExamenes.models.Usuario;
import com.sistema.GestionamientoExamenes.models.UsuarioRol;
import com.sistema.GestionamientoExamenes.repositories.RepositoryRol;
import com.sistema.GestionamientoExamenes.repositories.RepositoryUsuario;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author perez
 */
@Service
public class ServiceImplUsuario implements ServiceUsuario{

    @Autowired private RepositoryUsuario ru;
    
    @Autowired private RepositoryRol rr;

    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles)
    throws Exception {
        Usuario u=ru.findByUsername(usuario.getUsername());
        
        if(u!=null){
            System.out.println("El usuario ya existe");
            throw new Exception("El usuario ya está presente");
        }else{
            for(UsuarioRol ur:usuarioRoles){
                rr.save(ur.getRol());
            }
            usuario.getUsuarioRoles().addAll(usuarioRoles);
            u=ru.save(usuario);
        }
        return u;
    }

    @Override
    public Usuario obtenerUsuario(String username) {
        return ru.findByUsername(username);
    }

    @Override
    public void eliminarUsuario(Long id) {
        ru.deleteById(id);
    }
}
