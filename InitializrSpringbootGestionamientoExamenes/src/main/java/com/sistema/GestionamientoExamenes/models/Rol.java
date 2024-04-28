package com.sistema.GestionamientoExamenes.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author perez
 */

@Entity
@Table(name="roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rol {
    
    @Id
    private Long rolId;
    private String nombre;
    
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy = "rol")
    @JsonIgnore
    private Set<UsuarioRol> usuarioRoles=new HashSet<>();
    
}
