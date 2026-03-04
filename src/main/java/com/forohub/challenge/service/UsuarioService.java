package com.forohub.challenge.service;

import com.forohub.challenge.dto.usuario.ActualizarUsuarioDTO;
import com.forohub.challenge.dto.usuario.RegistrarUsuarioDTO;
import com.forohub.challenge.model.Perfil;
import com.forohub.challenge.model.Usuario;
import com.forohub.challenge.repository.PerfilRepository;
import com.forohub.challenge.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public Usuario registarUsuario(RegistrarUsuarioDTO usuarioDTO){
        List<Perfil> perfiles = usuarioDTO.perfiles().stream().map(Perfil::new).toList();

        var usuario = new Usuario(usuarioDTO);
        usuario.setClave(passwordEncoder.encode(usuarioDTO.clave()));
        usuario.setPerfiles(perfiles);

        usuarioRepository.save(usuario);
        return usuario;
    }

    @Transactional
    public Usuario actualizarUsuario(ActualizarUsuarioDTO actualizarUsuarioDTO){
        var usuario = usuarioRepository.getReferenceById(actualizarUsuarioDTO.id());
        usuario.actualizarUsuario(actualizarUsuarioDTO);
        usuario.setClave(passwordEncoder.encode(actualizarUsuarioDTO.clave()));

        return usuario;
    }

    @Transactional
    public Usuario buscarUsuarioPorId(long id){
        return usuarioRepository.getReferenceById(id);
    }

    public Page<Usuario> litarUsarios(Pageable pageable){
        return usuarioRepository.findAllByActivoTrue(pageable);
    }

    @Transactional
    public void eliminarUsario(long id){
        var usuario = usuarioRepository.getReferenceById(id);
        usuario.eliminarUusuario();
        System.out.println("Usuario Eliminado correctamente");
    }
}
