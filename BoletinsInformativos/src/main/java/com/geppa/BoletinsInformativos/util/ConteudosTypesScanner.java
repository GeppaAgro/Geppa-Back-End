package com.geppa.BoletinsInformativos.util;

import com.geppa.BoletinsInformativos.domain.classes.conteudos.Conteudo;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ConteudosTypesScanner {

    private static final String BASE_PACKAGE_CONTEUDOS = "com.geppa.BoletinsInformativos.domain.classes.conteudos";

    public Set<Class<?>> getTiposConteudo() {
        Reflections reflections = new Reflections(BASE_PACKAGE_CONTEUDOS, new SubTypesScanner(false));
        Set<Class<?>> conteudosClass = reflections.getSubTypesOf(Object.class);
        conteudosClass.remove(Conteudo.class);
        return conteudosClass;
    }
}
