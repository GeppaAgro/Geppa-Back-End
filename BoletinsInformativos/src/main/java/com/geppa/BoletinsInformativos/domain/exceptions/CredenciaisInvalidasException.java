package com.geppa.BoletinsInformativos.domain.exceptions;

import com.geppa.BoletinsInformativos.util.enums.messages.MensagensExcecao;
import org.springframework.http.HttpStatus;

public class CredenciaisInvalidasException extends ExcecaoPersonalizada{
    public CredenciaisInvalidasException() {
        super(MensagensExcecao.CREDENCIAIS_INVALIDAS.getMensagem(), HttpStatus.FORBIDDEN);
    }
}
