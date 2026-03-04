package com.forohub.challenge.dto.topico;

import com.forohub.challenge.model.Topico_Estatus;
import jakarta.validation.constraints.NotNull;

public record ActualizarTopicoDTO(
        @NotNull long id,
        Topico_Estatus estatus
) {
}
