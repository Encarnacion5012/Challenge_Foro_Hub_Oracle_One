package com.forohub.challenge.service;

import com.forohub.challenge.dto.respuesta.RegistroRespuestaDTO;
import com.forohub.challenge.model.Respuesta;
import com.forohub.challenge.repository.RespuestaRepository;
import com.forohub.challenge.repository.TopicoRepository;
import com.forohub.challenge.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
