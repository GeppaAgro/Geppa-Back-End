package com.geppa.BoletinsInformativos.util.autoPreenchimentoAtributos;

import com.geppa.BoletinsInformativos.util.annotations.AutoPreenchimentoAtualizacao;
import com.geppa.BoletinsInformativos.util.annotations.AutoPreenchimentoCadastro;
import org.springframework.stereotype.Component;

@Component
public class AutoPreenchimentoAtributos {

    private final AutoPreenchimentoHelper autoPreenchimentoHelper;

    public AutoPreenchimentoAtributos(AutoPreenchimentoHelper autoPreenchimentoHelper) {
        this.autoPreenchimentoHelper = autoPreenchimentoHelper;
    }

    public void preCadastro(Object entity) {
        autoPreenchimentoHelper.preencherAtributosComAnnotation(entity, AutoPreenchimentoCadastro.class);
    }

    public void preAtualizacao(Object entity) {
        autoPreenchimentoHelper.preencherAtributosComAnnotation(entity, AutoPreenchimentoAtualizacao.class);
    }

}


