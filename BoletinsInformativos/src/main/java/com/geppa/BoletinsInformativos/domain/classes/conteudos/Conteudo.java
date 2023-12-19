package com.geppa.BoletinsInformativos.domain.classes.conteudos;

import com.geppa.BoletinsInformativos.domain.classes.BoletimInformativo;
import com.geppa.BoletinsInformativos.domain.classes.Tag;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Conteudo {

    private UUID id;
    private BoletimInformativo boletimInformativo;
    private String titulo;
    private String descricao;
    private String link;
    private Instant dataCadastro;
    private Instant dataAtualizacao;
    private List<Tag> tags = new ArrayList<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BoletimInformativo getBoletimInformativo() {
        return boletimInformativo;
    }

    public void setBoletimInformativo(BoletimInformativo boletimInformativo) {
        this.boletimInformativo = boletimInformativo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Instant getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Instant dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Instant getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Instant dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
