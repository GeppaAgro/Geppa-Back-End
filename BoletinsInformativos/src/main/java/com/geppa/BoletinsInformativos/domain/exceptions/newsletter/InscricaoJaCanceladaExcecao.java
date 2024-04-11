package com.geppa.BoletinsInformativos.domain.exceptions.newsletter;

import com.geppa.BoletinsInformativos.domain.exceptions.ExcecaoPersonalizada;
import com.geppa.BoletinsInformativos.util.enums.messages.MensagensExcecao;
import org.springframework.http.HttpStatus;

public class InscricaoJaCanceladaExcecao extends ExcecaoPersonalizada {
    public InscricaoJaCanceladaExcecao(String email) {
        super(MensagensExcecao.INSCRICAO_JA_CANCELADA.getMensagem() + email, HttpStatus.BAD_REQUEST);
    }
}
