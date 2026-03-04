package com.forohub.challenge.dto.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ActualizarRespuestaDTO(
        @NotNull long id,
        @NotBlank String mensaje,
        @NotBlank String solucion
) {
}
