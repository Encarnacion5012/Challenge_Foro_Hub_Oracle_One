package com.forohub.challenge.dto.authentication;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthenticacionDTO(
        @NotBlank @Email String email,
        @NotBlank  String clave
) {
}
