package com.geppa.BoletinsInformativos.domain.exceptions;

import com.geppa.BoletinsInformativos.util.enums.messages.MensagensExcecao;
import org.springframework.http.HttpStatus;

public class RegistroDuplicadoException extends ExcecaoPersonalizada {

    public RegistroDuplicadoException() {
        super(MensagensExcecao.REGISTRO_DUPLICADO.getMensagem(), HttpStatus.BAD_REQUEST);
    }
}
