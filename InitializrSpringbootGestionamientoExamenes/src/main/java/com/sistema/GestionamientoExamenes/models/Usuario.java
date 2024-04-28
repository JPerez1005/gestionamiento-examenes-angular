package com.sistema.GestionamientoExamenes.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name="usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private boolean enabled=true;
    private String perfil;
    
    @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy = "usuario")
    @JsonIgnore
    private Set<UsuarioRol> usuarioRoles=new HashSet<>();
    
}
