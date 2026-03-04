package com.forohub.challenge.service;

import com.forohub.challenge.dto.respuesta.ActualizarRespuestaDTO;
import com.forohub.challenge.dto.respuesta.RegistroRespuestaDTO;
import com.forohub.challenge.model.Respuesta;
import com.forohub.challenge.repository.RespuestaRepository;
import com.forohub.challenge.repository.TopicoRepository;
import com.forohub.challenge.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RespuestaService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RespuestaRepository respuestaRepository;
    @Autowired
    private TopicoRepository topicoRepository;

    @Transactional
    public Respuesta registrarRespuesta(RegistroRespuestaDTO respuestaDTO){
        var respuesta = new Respuesta(respuestaDTO);
        var autor = usuarioRepository.getReferenceById(respuestaDTO.id_autor());
        var topico = topicoRepository.getReferenceById(respuestaDTO.id_topico());

        respuesta.setAutor(autor);
        respuesta.setTopico(topico);
        respuestaRepository.save(respuesta);

        return respuesta;

    }

    @Transactional
    public Respuesta buscarRespuestaPorId(long id) {
        return respuestaRepository.getReferenceById(id);
    }

    @Transactional
    public Respuesta actualizarRespues(ActualizarRespuestaDTO respuestaDTO){
        var respuesta = respuestaRepository.getReferenceById(respuestaDTO.id());
        respuesta.actualizarRespuesta(respuestaDTO);

        return respuesta;
    }

    public Page<Respuesta> listarTodasLasRespuestas(Pageable pageable) {
        return respuestaRepository.findAllByActivoTrue(pageable);
    }

    @Transactional
    public void eliminarRespuesta(long id){
        var respuesta = respuestaRepository.getReferenceById(id);
        respuesta.eliminarResouesta();
        System.out.println("Respuesta ELiminada correctamente");
    }
}
