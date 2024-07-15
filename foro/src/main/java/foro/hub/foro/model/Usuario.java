package foro.hub.foro.model;

import foro.hub.foro.dto.DatosUsuario;
import jakarta.persistence.*;

import lombok.*;

@Embeddable
//@Entity(name = "Usuario")
//@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(of = "id")
public class Usuario {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long id;

    private String nombreUsuario;
    private String correoElectronico;
    private String contrasenia;

    public Usuario(DatosUsuario datosUsuario) {
        this.nombreUsuario = datosUsuario.nombreUsuario();
        this.correoElectronico = datosUsuario.correoElectronico();
        this.contrasenia = datosUsuario.contrasenia();

    }
}
