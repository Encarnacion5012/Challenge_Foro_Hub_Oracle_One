package com.forohub.challenge.service;

import com.forohub.challenge.dto.topico.ActualizarTopicoDTO;
import com.forohub.challenge.dto.topico.DetallesTopicoDTO;
import com.forohub.challenge.dto.topico.RegistroTopicoDTO;
import com.forohub.challenge.model.Topico;
import com.forohub.challenge.repository.CursoRepository;
import com.forohub.challenge.repository.TopicoRepository;
import com.forohub.challenge.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;

    @Transactional
    public Topico registrarTopico(RegistroTopicoDTO topicoDTO){
        var topico = new Topico(topicoDTO);

        var curso = cursoRepository.getReferenceById(topicoDTO.id_Curso());
        var autor = usuarioRepository.getReferenceById(topicoDTO.id_Autor());

        topico.setCurso(curso);
        topico.setAutor(autor);

        topicoRepository.save(topico);
        return topico;
    }

    @Transactional
    public Topico buscarTopicoPorId(long id){
        return topicoRepository.getReferenceById(id);
    }

    public Page<Topico> listarTodosLosTopicos (Pageable paginacion){
        return topicoRepository.findAllByActivoTrue(paginacion);
    }

    @Transactional
    public Topico actualizarTopico(ActualizarTopicoDTO topicoDTO) {
        var topico = topicoRepository.getReferenceById(topicoDTO.id());
        topico.actualizarTopico(topicoDTO.estatus());
        return topico;
    }
    @Transactional
    public void EliminarTopico(long id) {
        var topico = topicoRepository.getReferenceById(id);
        topico.elimnarTopico();
        System.out.println("Topico Eliminado Correctamente");

    }
}
