package com.sistema.GestionamientoExamenes.security;

import com.sistema.GestionamientoExamenes.Services.Impl.UserDetailsServiceImpl;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @author perez
 */

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{

    @Autowired private UserDetailsServiceImpl udsi;
    
    @Autowired private JwtUtil ju;
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestTokenHeader=request.getHeader("Authorization");
        String username=null;
        String jwtToken=null;
        
        if (requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer ")) {
            jwtToken=requestTokenHeader.substring(7);
            
            try{
                System.out.println
                    ("\n\n\nPasamos el token y "
                    + "obtenemos el nombre del "
                    + "usuario en el token\n\n\n");
                username=this.ju.extractUsername(jwtToken);
            }catch(ExpiredJwtException expired){
                System.out.println("linea 45 Clase:JwtAuthenticationFilter");
                System.out.println("El token ah expirado");
            }catch(Exception e){
                System.out.println("linea 39 Clase:JwtAuthenticationFilter");
                System.out.println("Hubo algún error");
                System.out.println("=======================");
                System.out.println("=======================");
                System.out.println("=======================");
                e.printStackTrace();
            }
            
        } else {
            System.out.println("Token no autorizado, probablemente esté nulo o no contiene un Bearer");
        }
        
        if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails ud=this.udsi.loadUserByUsername(username);
            if(this.ju.validateToken(jwtToken, ud)){
                UsernamePasswordAuthenticationToken upat=new UsernamePasswordAuthenticationToken(ud, null,ud.getAuthorities());
                upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                
                SecurityContextHolder.getContext().setAuthentication(upat);
            }else{
                System.out.println("Clase: JwtAuthenticationFilter");
                System.out.println("Hubo algún error con el token, linea 61");
                System.out.println("=======================");
                System.out.println("=======================");
                System.out.println("=======================");
            }
            filterChain.doFilter(request, response);
        }
    }

}
