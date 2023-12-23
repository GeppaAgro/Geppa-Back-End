package com.geppa.BoletinsInformativos.domain.exceptions;

import com.geppa.BoletinsInformativos.util.messages.MensagensExcecao;

public class HashInvalidaExcecao extends IllegalArgumentException {
    public HashInvalidaExcecao(String hash) {
        super(MensagensExcecao.HASH_INVALIDA.getMensagem() + hash);
    }
}
