package com.geppa.BoletinsInformativos.domain.exceptions;

import com.geppa.BoletinsInformativos.util.messages.MensagensExcecao;
import org.springframework.http.HttpStatus;

public class OrdenacaaoInvalidaExcecao extends ExcecaoPersonalizada {
    public OrdenacaaoInvalidaExcecao(String ordenacaoInvalida) {
        super(MensagensExcecao.ORDENACAO_INVALIDA.getMensagem() + ordenacaoInvalida, HttpStatus.BAD_REQUEST);
    }
}
