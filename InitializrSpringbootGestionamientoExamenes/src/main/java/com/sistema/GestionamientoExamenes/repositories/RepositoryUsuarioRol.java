package com.sistema.GestionamientoExamenes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.GestionamientoExamenes.models.UsuarioRol;

@Repository 
public interface RepositoryUsuarioRol extends JpaRepository<UsuarioRol, Long>{
    
}
