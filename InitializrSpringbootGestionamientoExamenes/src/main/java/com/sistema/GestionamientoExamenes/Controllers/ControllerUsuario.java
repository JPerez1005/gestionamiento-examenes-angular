package com.sistema.GestionamientoExamenes.Controllers;

import com.sistema.GestionamientoExamenes.Services.ServiceUsuario;
import com.sistema.GestionamientoExamenes.models.Rol;
import com.sistema.GestionamientoExamenes.models.Usuario;
import com.sistema.GestionamientoExamenes.models.UsuarioRol;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author perez
 */
@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class ControllerUsuario {
    
    @Autowired private ServiceUsuario su;
    
    @PostMapping("/")
    public Usuario guardarUsuario(@RequestBody Usuario usuario)
    throws Exception{
        usuario.setPerfil("default.png");
        Set<UsuarioRol> roles=new HashSet<>();
        
        Rol rol=new Rol();
        rol.setRolId(1L);
        rol.setNombre("normal");
        
        UsuarioRol ur=new UsuarioRol();
        ur.setUsuario(usuario);
        ur.setRol(rol);
        
        return su.guardarUsuario(usuario, roles);
    }
    
    @GetMapping("/{username}")
    public Usuario obtenerUsuario(@PathVariable("username") String username){
        return su.obtenerUsuario(username);
    }
    
    @DeleteMapping("/{usuarioId}")
    public void eliminarUsuario(@PathVariable("usuarioId") Long usuarioId){
        su.eliminarUsuario(usuarioId);
    }
    
}
