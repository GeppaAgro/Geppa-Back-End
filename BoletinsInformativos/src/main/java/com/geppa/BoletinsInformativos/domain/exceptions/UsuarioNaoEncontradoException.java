package com.geppa.BoletinsInformativos.domain.exceptions;

import com.geppa.BoletinsInformativos.util.enums.messages.MensagensExcecao;
import org.springframework.http.HttpStatus;

public class UsuarioNaoEncontradoException extends ExcecaoPersonalizada{
    public UsuarioNaoEncontradoException() {
        super(MensagensExcecao.USUARIO_NAO_ENCONTRADO.getMensagem(), HttpStatus.NOT_FOUND);
    }
}
