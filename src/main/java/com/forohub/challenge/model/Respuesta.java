package com.forohub.challenge.model;

import com.forohub.challenge.dto.respuesta.RegistroRespuestaDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "respuestas")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;

    private LocalDate fecha_Creacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")

    private Usuario autor;
    private String solucion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_topico")
    private Topico topico;


    public Respuesta(RegistroRespuestaDTO respuestaDTO){
        this.mensaje = respuestaDTO.mensaje();
        this.fecha_Creacion = respuestaDTO.fecha_Creacion();
        this.solucion = respuestaDTO.solucion();
    }


}
