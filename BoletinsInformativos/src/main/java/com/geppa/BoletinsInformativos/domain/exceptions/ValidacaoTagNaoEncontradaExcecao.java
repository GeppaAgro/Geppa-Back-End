package com.geppa.BoletinsInformativos.domain.exceptions;

import com.geppa.BoletinsInformativos.util.enums.messages.MensagensExcecao;
import org.springframework.http.HttpStatus;

public class ValidacaoTagNaoEncontradaExcecao extends ExcecaoPersonalizada {
    public ValidacaoTagNaoEncontradaExcecao(String nomeTag) {
        super(MensagensExcecao.TAG_NAO_ENCONTRADA.getMensagem() + " - " + nomeTag, HttpStatus.BAD_REQUEST);
    }
}
