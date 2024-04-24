package com.geppa.BoletinsInformativos.application.dtos.cadastro.conteudos;

import com.geppa.BoletinsInformativos.application.dtos.cadastro.BoletimInformativoCadastroDto;
import com.geppa.BoletinsInformativos.application.dtos.retorno.TagDto;

import java.util.List;

public abstract class ConteudoCadastroDto {

    private BoletimInformativoCadastroDto boletimInformativo;
    private String titulo;
    private String descricao;
    private String link;
    private List<TagDto> tags;

    public ConteudoCadastroDto() {
    }

    public BoletimInformativoCadastroDto getBoletimInformativo() {
        return boletimInformativo;
    }

    public void setBoletimInformativo(BoletimInformativoCadastroDto boletimInformativo) {
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

    public List<TagDto> getTags() {
        return tags;
    }

    public void setTags(List<TagDto> tags) {
        this.tags = tags;
    }
}
