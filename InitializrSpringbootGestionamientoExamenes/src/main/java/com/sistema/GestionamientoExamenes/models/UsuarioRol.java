package com.sistema.GestionamientoExamenes.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author perez
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioRolId;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JsonIgnore
    private Usuario usuario;
    
    @ManyToOne
    @JsonIgnore
    private Rol rol;
    
}
