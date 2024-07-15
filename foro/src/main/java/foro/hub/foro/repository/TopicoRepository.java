package foro.hub.foro.repository;

import foro.hub.foro.model.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {


    Page<Topico> findByStatusTrue(Pageable paginacion);
}
