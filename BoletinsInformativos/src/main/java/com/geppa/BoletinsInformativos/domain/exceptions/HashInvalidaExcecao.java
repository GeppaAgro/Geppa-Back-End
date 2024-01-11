package com.geppa.BoletinsInformativos.domain.exceptions;

import com.geppa.BoletinsInformativos.util.messages.MensagensExcecao;
import org.springframework.http.HttpStatus;

public class HashInvalidaExcecao extends ExcecaoPersonalizada {
    public HashInvalidaExcecao(String hash) {
        super(MensagensExcecao.HASH_INVALIDA.getMensagem() + hash, HttpStatus.BAD_REQUEST);
    }
}
