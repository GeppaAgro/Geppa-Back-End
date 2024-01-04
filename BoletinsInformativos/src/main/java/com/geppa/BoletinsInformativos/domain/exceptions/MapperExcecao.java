package com.geppa.BoletinsInformativos.domain.exceptions;

import org.springframework.http.HttpStatus;

public class MapperExcecao extends ExcecaoPersonalizada{

        public MapperExcecao(String mensagem) {
                super(mensagem, HttpStatus.INTERNAL_SERVER_ERROR);
        }
}
