package foro.hub.foro.model;


import foro.hub.foro.dto.DatosActualizarTopico;
import foro.hub.foro.dto.DatosRegistroTopico;

import foro.hub.foro.enume.Curso;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String titulo;
    private String mensaje;

    private String telefono;

    @CreationTimestamp
    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    private Curso curso;

    //@ManyToOne(fetch = FetchType.EAGER)
    @Embedded
    private Usuario usuario;

    private Boolean status;



    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.status = true;

        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.telefono = datosRegistroTopico.telefono();
        this.fechaCreacion = LocalDateTime.now();
        this.curso = datosRegistroTopico.curso();
        this.usuario = new Usuario(datosRegistroTopico.user()) ;

    }

    public void actualizarDato(DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.titulo() != null){
            this.titulo = datosActualizarTopico.titulo();
        }

        if(datosActualizarTopico.mensaje() != null){
            this.mensaje = datosActualizarTopico.mensaje();
        }

        if(datosActualizarTopico.fechaCreacion() != null){
            this.fechaCreacion = LocalDateTime.now();
        }

    }

    public void desactivarTopico() {
        this.status = false;
    }


















    // vamos a gettear

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }



}
