package com.forohub.challenge.controller;

import com.forohub.challenge.dto.topico.ActualizarTopicoDTO;
import com.forohub.challenge.dto.topico.DetallesTopicoDTO;
import com.forohub.challenge.dto.topico.RegistroTopicoDTO;
import com.forohub.challenge.service.TopicoService;
import jakarta.validation.Valid;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topico")
public class TipicoController {
    @Autowired
    private TopicoService topicoService;

    @PostMapping()
    public ResponseEntity registrarTopico(@RequestBody @Valid RegistroTopicoDTO topicoDTO, UriComponentsBuilder uriComponentsBuilder){
        var topico = topicoService.registrarTopico(topicoDTO);
         var uri= uriComponentsBuilder.path("topicos/{id}").buildAndExpand(topico.getId()).toUri();

         return ResponseEntity.created(uri).body(new DetallesTopicoDTO(topico));

    }

    @GetMapping("/{id}")
    public ResponseEntity buscarTopicoPorid(@PathVariable long id){
       var topico =  topicoService.buscarTopicoPorId(id);

      return ResponseEntity.ok(new DetallesTopicoDTO(topico));
    }

    @GetMapping()
    public ResponseEntity listarTopicos(@PageableDefault(size = 10, sort = {"titulo"}) Pageable paginacion){
       var page = topicoService.listarTodosLosTopicos(paginacion)
               .map(DetallesTopicoDTO::new);
      return ResponseEntity.ok(page);
    }

    @PutMapping()
    public ResponseEntity actualizarTopico(@RequestBody ActualizarTopicoDTO topicoDTO){
       var topico = topicoService.actualizarTopico(topicoDTO);
       return ResponseEntity.ok(new DetallesTopicoDTO(topico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eleimarTopico (@PathVariable long id){
        topicoService.EliminarTopico(id);
        return   ResponseEntity.noContent().build();
    }
}
