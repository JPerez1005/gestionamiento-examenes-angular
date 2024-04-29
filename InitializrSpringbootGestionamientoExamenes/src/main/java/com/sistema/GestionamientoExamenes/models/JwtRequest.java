package com.sistema.GestionamientoExamenes.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author perez
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JwtRequest {

    private String username;
    
    private String password;
    
}
