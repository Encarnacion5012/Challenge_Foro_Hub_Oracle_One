package com.forohub.challenge.dto.usuario;

import jakarta.validation.constraints.NotBlank;

public record IniciarSecionDTO(
      @NotBlank String login,
      @NotBlank  String clave
) {
}
