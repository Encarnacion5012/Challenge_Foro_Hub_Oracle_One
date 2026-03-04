package com.forohub.challenge.controller;

import com.forohub.challenge.dto.usuario.ActualizarUsuarioDTO;
import com.forohub.challenge.dto.usuario.DetallesUsuarioCraeationDTO;
import com.forohub.challenge.dto.usuario.RegistrarUsuarioDTO;
import com.forohub.challenge.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController()
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registro")
    public ResponseEntity registrarUusario(@RequestBody @Valid RegistrarUsuarioDTO usuarioDTO, UriComponentsBuilder uriComponentsBuilder){
        var usuario =  usuarioService.registarUsuario(usuarioDTO);
        var uri = uriComponentsBuilder.path("/usuario/registro/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetallesUsuarioCraeationDTO(usuario));

    }

    @GetMapping("/{id}")
    public ResponseEntity buscarUsuarioPorId(@PathVariable long id){
        var usuario = usuarioService.buscarUsuarioPorId(id);
        return ResponseEntity.ok(new DetallesUsuarioCraeationDTO(usuario));
    }


    @PutMapping
    public ResponseEntity actualizarUusuario(@RequestBody @Valid ActualizarUsuarioDTO usuarioDTO){
        var usuario = usuarioService.actualizarUsuario(usuarioDTO);
        return ResponseEntity.ok(new DetallesUsuarioCraeationDTO(usuario));
    }

    @GetMapping()
    public ResponseEntity listarTodosLosUsuarios(@PageableDefault(size = 10, sort = {"nombre"})Pageable paginacion){
        var usuarios = usuarioService.litarUsarios(paginacion).
                map(DetallesUsuarioCraeationDTO::new).toList();

        return ResponseEntity.ok(usuarios);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarUusario(@PathVariable long id){
        usuarioService.eliminarUsario(id);
        return ResponseEntity.noContent().build();
    }

}
