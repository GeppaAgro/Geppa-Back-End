package com.geppa.BoletinsInformativos.domain.exceptions;

import com.geppa.BoletinsInformativos.util.enums.messages.MensagensExcecao;
import org.springframework.http.HttpStatus;

public class RegistroNaoEncontradoException extends ExcecaoPersonalizada {
    public RegistroNaoEncontradoException() {
        super(MensagensExcecao.REGISTRO_NAO_ENCONTRADO.getMensagem(), HttpStatus.NOT_FOUND);
    }
}
