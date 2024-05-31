package com.geppa.BoletinsInformativos.domain.useCases.user.auth;

import com.geppa.BoletinsInformativos.application.dtos.security.AccountCredentialsDto;
import com.geppa.BoletinsInformativos.application.dtos.security.TokenDto;
import com.geppa.BoletinsInformativos.domain.classes.security.User;
import com.geppa.BoletinsInformativos.domain.exceptions.CredenciaisInvalidasException;
import com.geppa.BoletinsInformativos.domain.exceptions.UsuarioNaoEncontradoException;
import com.geppa.BoletinsInformativos.infrastructure.gateways.GatewayUserRepositorio;
import com.geppa.BoletinsInformativos.infrastructure.security.JwtTokenProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class RealizarAutenticacao {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;
    private final GatewayUserRepositorio repository;

    public RealizarAutenticacao(AuthenticationManager authenticationManager, JwtTokenProvider tokenProvider, GatewayUserRepositorio repository) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
        this.repository = repository;
    }

    public TokenDto signin(AccountCredentialsDto data) {
        try {
            String username = data.getUsername();
            String password = data.getPassword();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

            User user = repository.findByUserName(username);

            if (user != null) {
                return tokenProvider.createAccessToken(username, user.getRoles());
            } else {
                throw new UsuarioNaoEncontradoException();
            }
        } catch (Exception e) {
            throw new CredenciaisInvalidasException();
        }
    }
}