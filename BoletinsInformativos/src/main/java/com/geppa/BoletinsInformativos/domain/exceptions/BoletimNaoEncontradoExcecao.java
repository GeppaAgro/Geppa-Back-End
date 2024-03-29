package com.geppa.BoletinsInformativos.domain.exceptions;

import com.geppa.BoletinsInformativos.util.enums.messages.MensagensExcecao;
import org.springframework.http.HttpStatus;

public class BoletimNaoEncontradoExcecao extends ExcecaoPersonalizada {
    public BoletimNaoEncontradoExcecao(String edicao) {
        super(MensagensExcecao.BOLETIM_NAO_ENCONTRADO_EDICAO.getMensagem() + edicao, HttpStatus.NOT_FOUND);
    }
}
