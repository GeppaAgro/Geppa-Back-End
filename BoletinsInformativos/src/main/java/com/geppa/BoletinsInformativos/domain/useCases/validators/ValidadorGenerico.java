package com.geppa.BoletinsInformativos.domain.useCases.validators;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class ValidadorGenerico {

    private final Validator validator;

    public ValidadorGenerico(Validator validator) {
        this.validator = validator;
    }

    public <T> void validar(T object, Errors errors) {
        validator.validate(object, errors);
    }
}
