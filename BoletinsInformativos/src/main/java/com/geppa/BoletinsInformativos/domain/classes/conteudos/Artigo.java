package com.geppa.BoletinsInformativos.domain.classes.conteudos;

import com.geppa.BoletinsInformativos.domain.classes.Autor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Artigo extends Conteudo {

    private LocalDate dataPublicacao;

    private List<Autor> autores = new ArrayList<>();

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
}
