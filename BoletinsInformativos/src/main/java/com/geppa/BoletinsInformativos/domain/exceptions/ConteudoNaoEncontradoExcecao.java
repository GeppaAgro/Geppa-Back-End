package com.geppa.BoletinsInformativos.domain.exceptions;

import com.geppa.BoletinsInformativos.util.enums.messages.MensagensExcecao;
import org.springframework.http.HttpStatus;

public class ConteudoNaoEncontradoExcecao extends ExcecaoPersonalizada {
    public ConteudoNaoEncontradoExcecao(String hash) {
        super(MensagensExcecao.CONTEUDO_NAO_ENCONTRADO_HASH.getMensagem() + hash, HttpStatus.NOT_FOUND);
    }
}
