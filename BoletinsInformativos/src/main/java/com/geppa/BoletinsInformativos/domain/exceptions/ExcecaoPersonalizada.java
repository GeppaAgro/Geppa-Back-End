package com.geppa.BoletinsInformativos.domain.exceptions;

import org.springframework.http.HttpStatus;

public abstract class ExcecaoPersonalizada extends RuntimeException {

    private final HttpStatus status;
    public ExcecaoPersonalizada(String mensagem, HttpStatus status) {
        super(mensagem);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
