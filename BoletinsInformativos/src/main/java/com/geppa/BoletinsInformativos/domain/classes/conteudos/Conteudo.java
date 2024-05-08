package com.geppa.BoletinsInformativos.domain.classes.conteudos;

import com.geppa.BoletinsInformativos.domain.classes.BoletimInformativo;
import com.geppa.BoletinsInformativos.domain.classes.Tag;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Conteudo {

    private UUID id;

    private BoletimInformativo boletimInformativo;

    @NotEmpty(message = "{conteudo.titulo.notEmpty}")
    @Size(min = 3, message = "{conteudo.titulo.size}")
    private String titulo;

    @NotEmpty(message = "{conteudo.descricao.notEmpty}")
    @Size(min = 10, message = "{conteudo.descricao.size}")
    private String descricao;

    @NotEmpty(message = "{conteudo.link.notEmpty}")
    @URL(message = "{conteudo.link.url}")
    private String link;
    private Instant dataCadastro;
    private Instant dataAtualizacao;

    @NotNull(message = "{conteudo.tags.notNull}")
    @Size(min = 1, message = "{conteudo.tags.size}")
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
