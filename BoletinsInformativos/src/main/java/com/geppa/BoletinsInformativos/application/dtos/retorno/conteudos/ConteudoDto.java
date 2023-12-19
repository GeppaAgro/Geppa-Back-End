package com.geppa.BoletinsInformativos.application.dtos.retorno.conteudos;

import com.geppa.BoletinsInformativos.application.dtos.retorno.TagDTO;
import org.springframework.hateoas.RepresentationModel;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public abstract class ConteudoDto extends RepresentationModel<ConteudoDto> {

    private UUID id;
    private String boletimInformativoEdicao;
    private String titulo;
    private String descricao;
    private String link;
    private Instant dataCadastro;
    private Instant dataAtualizacao;
    private List<TagDTO> tags;

    public ConteudoDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getBoletimInformativoEdicao() {
        return boletimInformativoEdicao;
    }

    public void setBoletimInformativoEdicao(String boletimInformativoEdicao) {
        this.boletimInformativoEdicao = boletimInformativoEdicao;
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

    public List<TagDTO> getTags() {
        return tags;
    }

    public void setTags(List<TagDTO> tags) {
        this.tags = tags;
    }
}
