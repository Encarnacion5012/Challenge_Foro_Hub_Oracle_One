package com.forohub.challenge.dto.usuario;

import jakarta.validation.constraints.NotBlank;

public record PerfilDTO(
        @NotBlank String nombre
) {
}
