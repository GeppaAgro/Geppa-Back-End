package com.geppa.BoletinsInformativos.domain.useCases.genericos;

import com.geppa.BoletinsInformativos.domain.exceptions.ValidacaoExcecao;
import com.geppa.BoletinsInformativos.domain.useCases.validators.ValidadorGenerico;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

@Service
public class ValidarObjeto <T>{

    private final ValidadorGenerico validadorGenerico;

    public ValidarObjeto(ValidadorGenerico validadorGenerico) {
        this.validadorGenerico = validadorGenerico;
    }

    public void executar(T objeto) {
        String nomeClasse = objeto.getClass().getSimpleName();
        Errors errors = new BeanPropertyBindingResult(objeto, nomeClasse);
        validadorGenerico.validar(objeto, errors);
        if (errors.hasErrors()) {
            throw new ValidacaoExcecao(errors);
        }
    }
}
