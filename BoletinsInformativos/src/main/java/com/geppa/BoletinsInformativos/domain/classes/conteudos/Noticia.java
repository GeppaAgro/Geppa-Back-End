package com.geppa.BoletinsInformativos.domain.classes.conteudos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

public class Noticia extends Conteudo {

    @NotNull(message = "{noticia.data_publicacao.obrigatorio}")
    @Past(message = "{noticia.dataPublicacao.past}")
    private LocalDate dataPublicacao;

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
}
