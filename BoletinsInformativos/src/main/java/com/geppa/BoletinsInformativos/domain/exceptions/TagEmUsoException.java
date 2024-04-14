package com.geppa.BoletinsInformativos.domain.exceptions;

import com.geppa.BoletinsInformativos.util.enums.messages.MensagensExcecao;
import org.springframework.http.HttpStatus;

public class TagEmUsoException extends ExcecaoPersonalizada {

    public TagEmUsoException(Long quantidadeDeConteudos) {
        super(MensagensExcecao.TAG_EM_USO.getMensagem() + quantidadeDeConteudos, HttpStatus.BAD_REQUEST);
    }
}
