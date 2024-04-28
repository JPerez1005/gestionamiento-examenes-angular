package com.sistema.GestionamientoExamenes.Services.Impl;

import com.sistema.GestionamientoExamenes.Services.ServiceUsuario;
import com.sistema.GestionamientoExamenes.models.Rol;
import com.sistema.GestionamientoExamenes.models.Usuario;
import com.sistema.GestionamientoExamenes.models.UsuarioRol;
import com.sistema.GestionamientoExamenes.repositories.RepositoryRol;
import com.sistema.GestionamientoExamenes.repositories.RepositoryUsuario;
import com.sistema.GestionamientoExamenes.repositories.RepositoryUsuarioRol;

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

    @Autowired private RepositoryUsuarioRol rur;

    @Override
    public Usuario guardarUsuario(Usuario usuario, Rol rol, UsuarioRol ur)
    throws Exception {
        Usuario u=ru.findByUsername(usuario.getUsername());
        
        if(u!=null){
            System.out.println("El usuario ya existe");
            throw new Exception("El usuario ya está presente");
        }else{
            rr.save(rol);
            u=ru.save(usuario);
            rur.save(ur);
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
