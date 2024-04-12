package com.geppa.BoletinsInformativos.domain.exceptions;

import org.springframework.http.HttpStatus;

public class DelecaoInvalidaExcecao extends ExcecaoPersonalizada{

    public DelecaoInvalidaExcecao(String mensagem) {
        super(mensagem, HttpStatus.BAD_REQUEST);
    }
}
