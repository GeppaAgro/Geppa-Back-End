package com.geppa.BoletinsInformativos.application.exceptions.handler;

import com.geppa.BoletinsInformativos.application.dtos.retorno.RetornoPadraoDto;
import com.geppa.BoletinsInformativos.domain.exceptions.ExcecaoPersonalizada;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ManipuladorRespostasExcecoes extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ExcecaoPersonalizada.class)
    public final ResponseEntity<RetornoPadraoDto> handleExcecaoPersonalizada(ExcecaoPersonalizada ex) {
        RetornoPadraoDto respostaExcecao = new RetornoPadraoDto(ex.getMessage(), ex.getStatus().value());
        return new ResponseEntity<>(respostaExcecao, ex.getStatus());
    }

}
