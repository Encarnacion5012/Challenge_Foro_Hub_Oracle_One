package com.forohub.challenge.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record IniciarSecionDTO(
      @NotBlank @Email String email,
      @NotBlank  String clave
) {
}
