package com.forohub.challenge.dto.usuario;

import com.forohub.challenge.model.Usuario;

import java.util.List;

public record DetallesUsuarioCraeationDTO(
        long id,
         String nombre,
         String email,
        List<Long> id_perfiles

) {
    public DetallesUsuarioCraeationDTO(Usuario u){
        this(
                u.getId(),
                u.getNombre(),
                u.getEmail(),
                u.getPerfiles().stream().map(p-> p.getId()).toList()
                );
    }
}
