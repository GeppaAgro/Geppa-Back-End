package com.geppa.BoletinsInformativos.util.annotations;


import com.geppa.BoletinsInformativos.util.enums.TipoPreenchimento;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoPreenchimentoAtualizacao {
    TipoPreenchimento value();
    boolean booleanValue() default false;
}