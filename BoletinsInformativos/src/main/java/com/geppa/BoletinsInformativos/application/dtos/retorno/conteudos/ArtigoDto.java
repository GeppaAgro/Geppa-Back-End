package com.geppa.BoletinsInformativos.application.dtos.retorno.conteudos;

import com.geppa.BoletinsInformativos.application.dtos.retorno.AutorDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArtigoDto extends ConteudoDto {

    private LocalDate dataPublicacao;
    private List<AutorDto> autores = new ArrayList<>();

    public ArtigoDto() {
    }
    public String getTipo() {
        return "Artigo";
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public List<AutorDto> getAutores() {
        return autores;
    }

    public void setAutores(List<AutorDto> autores) {
        this.autores = autores;
    }
}
