package com.geppa.BoletinsInformativos.application.exceptions.handler;

import com.geppa.BoletinsInformativos.application.dtos.retorno.RetornoPadraoDto;
import com.geppa.BoletinsInformativos.domain.exceptions.ConteudoNaoEncontradoExcecao;
import com.geppa.BoletinsInformativos.domain.exceptions.HashInvalidaExcecao;
import com.geppa.BoletinsInformativos.domain.exceptions.MapperExcecao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ManipuladorRespostasExcecoes extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<RetornoPadraoDto> handleRuntimeException(Exception ex) {
        RetornoPadraoDto respostaExcecao = new RetornoPadraoDto(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(respostaExcecao, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HashInvalidaExcecao.class)
    public final ResponseEntity<RetornoPadraoDto> handleHashInvalidaExcecao(Exception ex) {
        RetornoPadraoDto respostaExcecao = new RetornoPadraoDto(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(respostaExcecao, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConteudoNaoEncontradoExcecao.class)
    public final ResponseEntity<RetornoPadraoDto> handleConteudoNaoEncontradoExcecao(Exception ex) {
        RetornoPadraoDto respostaExcecao = new RetornoPadraoDto(ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(respostaExcecao, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MapperExcecao.class)
    public final ResponseEntity<RetornoPadraoDto> handleMapperExcecao(Exception ex) {
        RetornoPadraoDto respostaExcecao = new RetornoPadraoDto(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(respostaExcecao, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
