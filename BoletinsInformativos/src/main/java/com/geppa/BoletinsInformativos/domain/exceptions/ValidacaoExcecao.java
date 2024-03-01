package com.geppa.BoletinsInformativos.domain.exceptions;

import com.geppa.BoletinsInformativos.util.enums.messages.MensagensExcecao;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;

public class ValidacaoExcecao extends ExcecaoPersonalizada {

    private final Errors errors;

    public ValidacaoExcecao(Errors errors) {
        super(MensagensExcecao.ERRO_VALIDACAO.getMensagem(), HttpStatus.BAD_REQUEST);
        this.errors = errors;
    }

    public Errors getErrors() {
        return errors;
    }
}
