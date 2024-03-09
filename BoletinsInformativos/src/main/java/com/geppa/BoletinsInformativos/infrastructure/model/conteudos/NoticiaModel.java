package com.geppa.BoletinsInformativos.infrastructure.model.conteudos;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "noticias")
public class NoticiaModel extends ConteudoModel {

    @Column(name = "not_data_publicacao")
    private LocalDate dataPublicacao;

    public NoticiaModel() {
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
}