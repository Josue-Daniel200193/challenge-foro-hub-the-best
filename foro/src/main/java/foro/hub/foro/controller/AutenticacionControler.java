package foro.hub.foro.controller;


import foro.hub.foro.dto.DatosAutenticacionUsuario;

import foro.hub.foro.dto.DatosJWTToken;
import foro.hub.foro.infra.security.TokenService;
import foro.hub.foro.model.UsuarioSesion;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/login")
public class AutenticacionControler {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;



    @PostMapping
    public ResponseEntity autenticarUsuarioSesion (@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario){

        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.correo(),
                datosAutenticacionUsuario.pass());


        var usuarioSesionAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((UsuarioSesion) usuarioSesionAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));


    }
}
