package com.forohub.challenge.model;

import com.forohub.challenge.dto.usuario.ActualizarUsuarioDTO;
import com.forohub.challenge.dto.usuario.RegistrarUsuarioDTO;
import jakarta.persistence.*;
import lombok.*;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Setter

@Entity
@Table(name = "usuarios")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private  String email;
    private String clave;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "usuarios_perfiles",
            joinColumns= @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_perfil"))
   private List<Perfil>perfiles;

    @OneToMany(mappedBy = "autor")
    private List<Respuesta> respuestas;

    @OneToMany(mappedBy = "autor")
    private List<Topico> topicos;

    private Boolean activo;

    public Usuario(RegistrarUsuarioDTO usuarioDTO) {
        this.nombre = usuarioDTO.nombre();
        this.email = usuarioDTO.email();
        this.activo = true;

    }

    public void actualizarUsuario(ActualizarUsuarioDTO usuarioDTO){
        if (usuarioDTO.email() != null){
            this.email = usuarioDTO.email();
        }
        if (usuarioDTO.clave() != null){
            this.clave = usuarioDTO.clave();
        }
    }

    public void eliminarUusuario(){
        this.activo =false;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public @Nullable String getPassword() {
        return clave;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
}
