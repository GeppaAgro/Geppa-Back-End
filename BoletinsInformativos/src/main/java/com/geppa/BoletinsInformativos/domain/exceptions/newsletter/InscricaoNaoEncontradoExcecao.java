package com.geppa.BoletinsInformativos.domain.exceptions.newsletter;

import com.geppa.BoletinsInformativos.domain.exceptions.ExcecaoPersonalizada;
import com.geppa.BoletinsInformativos.util.enums.messages.MensagensExcecao;
import org.springframework.http.HttpStatus;

public class InscricaoNaoEncontradoExcecao extends ExcecaoPersonalizada {
    public InscricaoNaoEncontradoExcecao(String email) {
        super(MensagensExcecao.INSCRICAO_NAO_ENCONTRADA.getMensagem() + email, HttpStatus.NOT_FOUND);
    }
}
