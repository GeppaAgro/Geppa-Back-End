package com.geppa.BoletinsInformativos.domain.exceptions;

import com.geppa.BoletinsInformativos.util.messages.MensagensExcecao;
import org.springframework.http.HttpStatus;

public class DadosNaoEncontradosExcecao extends ExcecaoPersonalizada {
    public DadosNaoEncontradosExcecao(String tipoDados) {
        super(MensagensExcecao.DADOS_NAO_ENCONTRADOS.getMensagem() + tipoDados, HttpStatus.NOT_FOUND);
    }
}
