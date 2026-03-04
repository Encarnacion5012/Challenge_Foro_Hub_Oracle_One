package com.forohub.challenge.dto.topico;

import com.forohub.challenge.model.Topico_Estatus;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RegistroTopicoDTO(
        @NotBlank String titulo,
        String mensaje,
        @FutureOrPresent(message = "La fecha no puede ser pasada")
        LocalDate fecha_Creacion,
        Topico_Estatus estatus,
        @NotNull long id_Autor,
        @NotNull long id_Curso
) {
}
