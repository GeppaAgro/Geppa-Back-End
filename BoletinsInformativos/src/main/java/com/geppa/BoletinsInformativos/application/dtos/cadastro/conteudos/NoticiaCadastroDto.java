package com.geppa.BoletinsInformativos.application.dtos.cadastro.conteudos;

import java.time.LocalDate;

public class NoticiaCadastroDto extends ConteudoCadastroDto {
    private LocalDate dataPublicacao;

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
}
