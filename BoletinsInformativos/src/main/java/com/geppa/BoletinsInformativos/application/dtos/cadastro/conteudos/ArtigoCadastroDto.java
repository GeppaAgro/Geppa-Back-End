package com.geppa.BoletinsInformativos.application.dtos.cadastro.conteudos;


import com.geppa.BoletinsInformativos.application.dtos.cadastro.AutorCadastroDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArtigoCadastroDto extends ConteudoCadastroDto {
    private LocalDate dataPublicacao;

    private List<AutorCadastroDto> autores = new ArrayList<>();

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public List<AutorCadastroDto> getAutores() {
        return autores;
    }

    public void setAutores(List<AutorCadastroDto> autores) {
        this.autores = autores;
    }
}
