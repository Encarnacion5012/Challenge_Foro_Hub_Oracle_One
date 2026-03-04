package com.forohub.challenge.model;

import com.forohub.challenge.dto.topico.RegistroTopicoDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Setter


@Entity
@Table(name = "topicos")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDate fecha_Creacion;

    @Enumerated(EnumType.STRING)
    private Topico_Estatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_autor")
    private Usuario autor;


    @OneToMany(mappedBy = "topico")
    List<Respuesta> respuestas;

    private Boolean activo;

    public Topico(RegistroTopicoDTO topicoDTO){
        this.titulo = topicoDTO.titulo();
        this.mensaje = topicoDTO.mensaje();
        this.fecha_Creacion = topicoDTO.fecha_Creacion();
        this.status = topicoDTO.estatus();
        this.activo = true;
    }

    public void actualizarTopico(Topico_Estatus status){
        if (status!= null){
            this.status = status;
            System.out.println("Topico actualizado Correctamente");
        }
    }

    public void elimnarTopico(){
        this.activo = false;
    }

}
