package com.geppa.BoletinsInformativos.domain.exceptions;

import com.geppa.BoletinsInformativos.util.messages.MensagensExcecao;

public class ConteudoNaoEncontradoExcecao extends RuntimeException {
    public ConteudoNaoEncontradoExcecao(String hash) {
        super(MensagensExcecao.CONTEUDO_NAO_ENCONTRADO_HASH.getMensagem() + hash);
    }
}
