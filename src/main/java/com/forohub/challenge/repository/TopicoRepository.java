package com.forohub.challenge.repository;

import com.forohub.challenge.model.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TopicoRepository extends JpaRepository<Topico, Long> {

     Page<Topico> findAllByActivoTrue(Pageable paginacion);
}
