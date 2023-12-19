package com.geppa.BoletinsInformativos.domain.exceptions;

public class HashInvalidaExcecao extends IllegalArgumentException {
    public HashInvalidaExcecao(String hash) {
        super("Hash inválido: " + hash);
    }
}
