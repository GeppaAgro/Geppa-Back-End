package com.geppa.BoletinsInformativos.application.controllers;

import com.geppa.BoletinsInformativos.application.dtos.padrao.RetornoPadraoDto;
import com.geppa.BoletinsInformativos.application.dtos.security.AccountCredentialsDto;
import com.geppa.BoletinsInformativos.application.dtos.security.TokenDto;
import com.geppa.BoletinsInformativos.domain.useCases.user.auth.RealizarAutenticacao;
import com.geppa.BoletinsInformativos.domain.useCases.user.auth.RefreshTokenAutenticacao;
import com.geppa.BoletinsInformativos.util.enums.messages.MensagensExcecao;
import com.geppa.BoletinsInformativos.util.enums.messages.MensagensRetorno;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AutenticacacaoController {

    private final RealizarAutenticacao realizarAutenticacao;
    private final RefreshTokenAutenticacao refreshTokenAutenticacao;


    public AutenticacacaoController(RealizarAutenticacao realizarAutenticacao, RefreshTokenAutenticacao refreshTokenAutenticacao) {
        this.realizarAutenticacao = realizarAutenticacao;
        this.refreshTokenAutenticacao = refreshTokenAutenticacao;
    }

    @PostMapping("/signin")
    public ResponseEntity<RetornoPadraoDto> signIn(@RequestBody AccountCredentialsDto credentials) {

        TokenDto token = realizarAutenticacao.signin(credentials);
        if (token == null)
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(
                    new RetornoPadraoDto(MensagensExcecao.CREDENCIAIS_INVALIDAS.getMensagem(), HttpStatus.FORBIDDEN.value()
                    ));
        return ResponseEntity.ok(new RetornoPadraoDto(
                MensagensRetorno.AUTEHTICACAO_SUCESSO.getMensagem(), HttpStatus.OK.value(), token
        ));
    }

    @PutMapping("/refresh/{username}")
    public ResponseEntity<RetornoPadraoDto> refreshToken(@PathVariable("username") String username,
                                                         @RequestHeader("Authorization") String refreshToken) {
        TokenDto token = refreshTokenAutenticacao.refreshToken(username, refreshToken);
        if (token == null)
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(
                    new RetornoPadraoDto(MensagensExcecao.CREDENCIAIS_INVALIDAS.getMensagem(), HttpStatus.FORBIDDEN.value()
                    ));
        return ResponseEntity.ok(new RetornoPadraoDto(
                MensagensRetorno.REFRESH_TOKEN_SUCESSO.getMensagem(),
                HttpStatus.OK.value(), token
        ));
    }
}
