package com.geppa.BoletinsInformativos.domain.exceptions;

public class ConteudoNaoEncontradoExcecao extends RuntimeException {
    public ConteudoNaoEncontradoExcecao(String nomeConteudo, String hash) {
        super(nomeConteudo + " não encontrado para o hash: " + hash);
    }
}
