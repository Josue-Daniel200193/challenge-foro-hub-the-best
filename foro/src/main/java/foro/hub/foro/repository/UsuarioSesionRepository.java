package foro.hub.foro.repository;

import foro.hub.foro.model.UsuarioSesion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioSesionRepository extends JpaRepository<UsuarioSesion, Long> {

    UserDetails findByCorreo(String username);
}
