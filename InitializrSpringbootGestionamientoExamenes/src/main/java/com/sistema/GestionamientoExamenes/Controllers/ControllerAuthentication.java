package com.sistema.GestionamientoExamenes.Controllers;

import com.sistema.GestionamientoExamenes.Services.Impl.UserDetailsServiceImpl;
import com.sistema.GestionamientoExamenes.models.JwtRequest;
import com.sistema.GestionamientoExamenes.models.JwtResponse;
import com.sistema.GestionamientoExamenes.models.Usuario;
import com.sistema.GestionamientoExamenes.security.JwtUtil;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author perez
 */

@RestController
@CrossOrigin("*")
public class ControllerAuthentication {

    @Autowired private UserDetailsServiceImpl udsi;
    
    @Autowired private AuthenticationManager am;
    
    @Autowired private JwtUtil ju;
    
    @PostMapping("/generate-token")
    public ResponseEntity<?> generarToken(@RequestBody JwtRequest jr) throws Exception{
        try {
            autenticar(jr.getUsername(), jr.getPassword());
        } catch (UsernameNotFoundException unfe) {
            System.out.println("Nombre de usuario no encontrado "+unfe);
        }
        
        UserDetails ud=this.udsi.loadUserByUsername(jr.getUsername());
        String token=this.ju.generateToken(ud);
        return ResponseEntity.ok(new JwtResponse(token));
    }
    
    private void autenticar(String username,String password) throws Exception{
        try {
            am.authenticate(new UsernamePasswordAuthenticationToken(password, username));
        } catch (DisabledException de) {
            throw new Exception("Usuario False "+de);
        } catch (BadCredentialsException bce){
            throw new Exception("Credenciales invalidas "+bce);
        }
    }
    
    @GetMapping("/actual-usuario")
    public Usuario obtenerUsuarioActual(Principal principal){
        return (Usuario) this.udsi.loadUserByUsername(principal.getName());
    }
    
}
