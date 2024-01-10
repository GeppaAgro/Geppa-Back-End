package com.geppa.BoletinsInformativos.domain.exceptions;

import com.geppa.BoletinsInformativos.util.messages.MensagensExcecao;
import org.springframework.http.HttpStatus;

public class BuscaInvalidaExcecao extends ExcecaoPersonalizada {
    public BuscaInvalidaExcecao() {
        super(MensagensExcecao.BUSCA_INVALIDA.getMensagem(), HttpStatus.BAD_REQUEST);
    }
}
