package com.forohub.challenge.controller;

import com.forohub.challenge.dto.authentication.AuthenticacionDTO;
import com.forohub.challenge.infra.security.token.TokenJWTDTO;
import com.forohub.challenge.infra.security.token.TokenService;
import com.forohub.challenge.model.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class authenticationController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager auManager;

    @PostMapping()
    public ResponseEntity inicarSesion(@RequestBody @Valid AuthenticacionDTO authenticacionDTO){
        var authenticationToken = new UsernamePasswordAuthenticationToken(authenticacionDTO.email(), authenticacionDTO.clave());
        var authentication = auManager.authenticate(authenticationToken);

        var tokenJWT = tokenService.genenerToken((Usuario) authentication.getPrincipal());
        return ResponseEntity.ok().body(new TokenJWTDTO(tokenJWT));
    }

}
