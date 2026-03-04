package com.forohub.challenge.model;

import com.forohub.challenge.dto.usuario.PerfilDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")


@Entity
@Table(name = "perfiles")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @ManyToMany(mappedBy = "perfiles")
    private List<Usuario> usuarios;

    public Perfil(PerfilDTO perfilDTO){
        this.nombre = perfilDTO.nombre();
    }
}


