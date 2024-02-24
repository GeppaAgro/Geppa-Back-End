package com.geppa.BoletinsInformativos.application.handler;

import com.geppa.BoletinsInformativos.application.dtos.padrao.RetornoPadraoDto;
import com.geppa.BoletinsInformativos.domain.exceptions.ExcecaoPersonalizada;
import com.geppa.BoletinsInformativos.domain.exceptions.ValidacaoExcecao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@RestController
public class ManipuladorRespostasExcecoes extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<RetornoPadraoDto> handleExcecaoPadrao(Exception ex) {
        RetornoPadraoDto respostaExcecao = new RetornoPadraoDto(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(respostaExcecao, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(ExcecaoPersonalizada.class)
    public final ResponseEntity<RetornoPadraoDto> handleExcecaoPersonalizada(ExcecaoPersonalizada ex) {
        RetornoPadraoDto respostaExcecao = new RetornoPadraoDto(ex.getMessage(), ex.getStatus().value());
        return new ResponseEntity<>(respostaExcecao, ex.getStatus());
    }

    @ExceptionHandler(ValidacaoExcecao.class)
    public ResponseEntity<RetornoPadraoDto> handleValidationException(ValidacaoExcecao exception) {
        Map<String, String> errorMap = new HashMap<>();
        exception.getErrors().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errorMap.put(fieldName, errorMessage);
        });
        RetornoPadraoDto respostaExcecao = new RetornoPadraoDto(exception.getMessage(),
                exception.getStatus().value(), errorMap);
        return new ResponseEntity<>(respostaExcecao, exception.getStatus());
    }

}
