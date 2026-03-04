package com.forohub.challenge.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record RegistrarUsuarioDTO(
      @NotBlank String nombre,
      @NotBlank @Email String email,
      @NotBlank  String clave,
      List<PerfilDTO> perfiles
) {
}
