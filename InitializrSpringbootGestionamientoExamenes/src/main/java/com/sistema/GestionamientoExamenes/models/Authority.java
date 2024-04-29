package com.sistema.GestionamientoExamenes.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author perez
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Authority implements GrantedAuthority{
    
    private String authority;

    @Override
    public String getAuthority() {
        return this.authority;
    }

}
