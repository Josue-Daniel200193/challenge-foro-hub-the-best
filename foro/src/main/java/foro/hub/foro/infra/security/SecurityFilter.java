package foro.hub.foro.infra.security;

import foro.hub.foro.model.UsuarioSesion;
import foro.hub.foro.repository.UsuarioSesionRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioSesionRepository usuarioSesionRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //obtener el toquen del header
        var authHeader = request.getHeader("Authorization");

        if(authHeader != null){
            System.out.println("validamos que toquen no es null");
            var token = authHeader.replace("Bearer ","");

            var nombreUser = tokenService.getSubject(token);
            System.out.println("nombre " + nombreUser);
            if(nombreUser != null){
                // Toquen valido
              UsuarioSesion u = (UsuarioSesion) usuarioSesionRepository.findByCorreo(nombreUser);
                System.out.println("u "+u);
                var authentication = new UsernamePasswordAuthenticationToken(u, null, u.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);

            }
        }
        filterChain.doFilter(request,response);


    }



}
