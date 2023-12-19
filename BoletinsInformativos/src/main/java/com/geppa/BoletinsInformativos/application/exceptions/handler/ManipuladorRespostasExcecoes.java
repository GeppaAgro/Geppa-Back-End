package com.geppa.BoletinsInformativos.application.exceptions.handler;

import com.geppa.BoletinsInformativos.application.exceptions.RespostaExcecao;
import com.geppa.BoletinsInformativos.domain.exceptions.ConteudoNaoEncontradoExcecao;
import com.geppa.BoletinsInformativos.domain.exceptions.HashInvalidaExcecao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
@RestController
public class ManipuladorRespostasExcecoes extends ResponseEntityExceptionHandler {

    @ExceptionHandler(HashInvalidaExcecao.class)
    public final ResponseEntity<RespostaExcecao> handleHashInvalidaExcecao(Exception ex, WebRequest request) {
        RespostaExcecao respostaExcecao = new RespostaExcecao(getDataHora(), HttpStatus.BAD_REQUEST.value(), ex.getMessage(), getPath(request));
        return new ResponseEntity<>(respostaExcecao, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConteudoNaoEncontradoExcecao.class)
    public final ResponseEntity<RespostaExcecao> handleConteudoNaoEncontradoExcecao(Exception ex, WebRequest request) {
        RespostaExcecao respostaExcecao = new RespostaExcecao(getDataHora(), HttpStatus.NOT_FOUND.value(), ex.getMessage(), getPath(request));
        return new ResponseEntity<>(respostaExcecao, HttpStatus.NOT_FOUND);
    }

    private String getDataHora() {
        LocalDateTime momentoAtual = LocalDateTime.now();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return momentoAtual.format(formatador);
    }

    private String getPath(WebRequest request) {
        return request.getDescription(false).split("=")[1];
    }

}
