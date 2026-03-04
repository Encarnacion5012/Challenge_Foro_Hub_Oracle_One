package com.forohub.challenge.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record ActualizarUsuarioDTO(
       @NotNull long id,
        String clave,
        @Email String email
) {
}
