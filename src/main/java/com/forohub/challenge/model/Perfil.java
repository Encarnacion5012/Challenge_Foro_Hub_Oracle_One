package com.forohub.challenge.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "perfiles")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @ManyToMany(mappedBy = "perfiles")
    private List<Usuario> usuarios;
}
