package com.geppa.BoletinsInformativos.application.dtos.retorno.conteudos;

import com.geppa.BoletinsInformativos.application.dtos.retorno.AutorDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArtigoDTO extends ConteudoDto {

    private LocalDate dataPublicacao;
    private List<AutorDTO> autores = new ArrayList<>();

    public ArtigoDTO() {
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public List<AutorDTO> getAutores() {
        return autores;
    }

    public void setAutores(List<AutorDTO> autores) {
        this.autores = autores;
    }
}
