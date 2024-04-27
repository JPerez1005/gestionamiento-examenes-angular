package com.sistema.GestionamientoExamenes.repositories;

import com.sistema.GestionamientoExamenes.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author perez
 */
@Repository
public interface RepositoryUsuario extends JpaRepository<Usuario, Long>{

    public Usuario findByUsername(String username);
    
}
