package com.forohub.challenge.dto.respuesta;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RegistroRespuestaDTO(
        @NotBlank String mensaje,
        @NotNull long id_topico,
        @FutureOrPresent LocalDate fecha_Creacion,
        @NotNull long id_autor,
        String solucion
) {
}
