package com.sistema.GestionamientoExamenes.Services.Impl;

import com.sistema.GestionamientoExamenes.models.Usuario;
import com.sistema.GestionamientoExamenes.repositories.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author perez
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private RepositoryUsuario ru;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario u=this.ru.findByUsername(username);
        if(u==null){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        
        return u;
    }

}
