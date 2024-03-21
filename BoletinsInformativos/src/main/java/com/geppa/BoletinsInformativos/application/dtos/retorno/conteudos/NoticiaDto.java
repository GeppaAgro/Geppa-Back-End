package com.geppa.BoletinsInformativos.application.dtos.retorno.conteudos;

import java.time.LocalDate;

public class NoticiaDto extends ConteudoDto {
    private LocalDate dataPublicacao;

    public String getTipo() {
        return "Noticia";
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
}
