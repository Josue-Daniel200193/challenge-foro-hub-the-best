package foro.hub.foro.dto;


import jakarta.validation.constraints.NotBlank;

public record DatosUsuario(

        @NotBlank
        String nombreUsuario,

        @NotBlank
        String correoElectronico,

        @NotBlank
        String contrasenia
) {

}
