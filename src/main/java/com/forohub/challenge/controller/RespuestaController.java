package com.forohub.challenge.controller;

import com.forohub.challenge.dto.respuesta.RegistroRespuestaDTO;
import com.forohub.challenge.service.RespuestaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/respuesta")
public class RespuestaController {
    @Autowired
    private RespuestaService respuestaService;

    @PostMapping()
    public ResponseEntity registarRespuesta(@RequestBody @Valid RegistroRespuestaDTO respuestaDTO, UriComponentsBuilder uriComponentsBuilder){
        var respuesta = respuestaService.registrarRespuesta(respuestaDTO);
        var uri = uriComponentsBuilder.path("/respuesta/{id}").buildAndExpand(respuesta.getId()).toUri();

        return ResponseEntity.created(uri).body(respuesta);
    }
}
