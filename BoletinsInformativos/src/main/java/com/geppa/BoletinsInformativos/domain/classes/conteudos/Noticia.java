package com.geppa.BoletinsInformativos.domain.classes.conteudos;

import java.time.LocalDate;

public class Noticia extends Conteudo {
    private LocalDate dataPublicacao;

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
}
