package com.forohub.challenge.dto.topico;

import com.forohub.challenge.model.Topico;
import com.forohub.challenge.model.Topico_Estatus;


import java.time.LocalDate;

public record DetallesTopicoDTO(
         long id,
         String tirulo,
         String mensaje,
         LocalDate fecha_Creacion,
         Topico_Estatus estatus,
         long id_Autor,
         long id_Curso
) {
    public DetallesTopicoDTO(Topico t) {
        this(t.getId(), t.getTitulo(), t.getMensaje(), t.getFecha_Creacion(),
                t.getStatus(), t.getAutor().getId(), t.getCurso().getId());
    }
}
