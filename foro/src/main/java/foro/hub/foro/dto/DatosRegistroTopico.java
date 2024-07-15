package foro.hub.foro.dto;

import foro.hub.foro.enume.Curso;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,

        @NotBlank
        String mensaje,

        @NotBlank
        String telefono,

        @NotNull
        @Valid
        DatosUsuario user,

        @NotNull
        Curso curso

) {
}
