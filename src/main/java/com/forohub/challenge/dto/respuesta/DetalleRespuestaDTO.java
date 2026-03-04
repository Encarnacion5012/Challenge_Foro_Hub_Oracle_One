package com.forohub.challenge.dto.respuesta;


import com.forohub.challenge.model.Respuesta;

import java.time.LocalDate;

public record DetalleRespuestaDTO(
        long id,
        String mensaje,
        long id_topico,
        LocalDate fecha_Creacion,
        long id_autor,
        String solucion
) {
    public DetalleRespuestaDTO(Respuesta p){
        this(p.getId(),
                p.getMensaje(),
                p.getTopico().getId(),
                p.getFecha_Creacion(),
                p.getAutor().getId(),
                p.getSolucion()
                );
    }
}
