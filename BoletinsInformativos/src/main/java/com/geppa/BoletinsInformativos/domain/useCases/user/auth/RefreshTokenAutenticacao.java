package com.geppa.BoletinsInformativos.domain.useCases.user.auth;

import com.geppa.BoletinsInformativos.application.dtos.security.TokenDto;
import com.geppa.BoletinsInformativos.domain.classes.security.User;
import com.geppa.BoletinsInformativos.domain.exceptions.CredenciaisInvalidasException;
import com.geppa.BoletinsInformativos.domain.exceptions.UsuarioNaoEncontradoException;
import com.geppa.BoletinsInformativos.infrastructure.gateways.GatewayUserRepositorio;
import com.geppa.BoletinsInformativos.infrastructure.security.JwtTokenProvider;
import org.springframework.stereotype.Service;

@Service
public class RefreshTokenAutenticacao {

    private final JwtTokenProvider tokenProvider;
    private final GatewayUserRepositorio repository;

    public RefreshTokenAutenticacao(JwtTokenProvider tokenProvider, GatewayUserRepositorio repository) {
        this.tokenProvider = tokenProvider;
        this.repository = repository;
    }

    public TokenDto refreshToken(String username, String refreshToken) {
        if (checkRefreshToken(username, refreshToken))
            throw new CredenciaisInvalidasException();

        User user = repository.findByUserName(username);

        if (user != null) {
            return tokenProvider.refreshToken(refreshToken);
        } else {
            throw new UsuarioNaoEncontradoException();
        }
    }

    private static boolean checkRefreshToken(String username, String refreshToken) {
        return username == null || username.isBlank() || refreshToken == null || refreshToken.isBlank();
    }

}