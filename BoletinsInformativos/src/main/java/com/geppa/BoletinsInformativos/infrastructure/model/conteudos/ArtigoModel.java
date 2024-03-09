package com.geppa.BoletinsInformativos.infrastructure.model.conteudos;

import com.geppa.BoletinsInformativos.infrastructure.model.AutorModel;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "artigos")
public class ArtigoModel extends ConteudoModel {

    @Column(name = "art_data_publicacao")
    private LocalDate dataPublicacao;

    @OneToMany(mappedBy = "artigo", cascade = CascadeType.ALL)
    private List<AutorModel> autores;

    public ArtigoModel() {
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public List<AutorModel> getAutores() {
        return autores;
    }

    public void setAutores(List<AutorModel> autores) {
        this.autores = autores;
    }

}