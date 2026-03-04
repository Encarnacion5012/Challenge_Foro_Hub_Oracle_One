package com.forohub.challenge.controller;

import com.forohub.challenge.dto.respuesta.ActualizarRespuestaDTO;
import com.forohub.challenge.dto.respuesta.DetalleRespuestaDTO;
import com.forohub.challenge.dto.respuesta.RegistroRespuestaDTO;
import com.forohub.challenge.service.RespuestaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

        return ResponseEntity.created(uri).body(new DetalleRespuestaDTO(respuesta));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarRespuestaPorID(@PathVariable long id){
        var respuesta = respuestaService.buscarRespuestaPorId(id);
        return ResponseEntity.ok(new DetalleRespuestaDTO(respuesta));
    }

    @PutMapping()
    public ResponseEntity actualizarRespuesta(@RequestBody @Valid ActualizarRespuestaDTO respuestaDTO){
        var respuesta = respuestaService.actualizarRespues(respuestaDTO);
        return ResponseEntity.ok(new DetalleRespuestaDTO(respuesta));
    }

    @GetMapping()
    public ResponseEntity listarTodasLasRespuestas(@PageableDefault(size = 10, sort = {"mensaje"})Pageable pageable) {
        var respuestas = respuestaService.listarTodasLasRespuestas(pageable)
                .map(DetalleRespuestaDTO::new);

        return ResponseEntity.ok(respuestas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eleiminarRespuesta(@PathVariable long id){
        respuestaService.eliminarRespuesta(id);
        return ResponseEntity.noContent().build();
    }
}
