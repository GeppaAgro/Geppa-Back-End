package com.geppa.BoletinsInformativos.application.dtos.retorno;

import com.geppa.BoletinsInformativos.application.dtos.retorno.conteudos.*;
import org.springframework.hateoas.RepresentationModel;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BoletimInformativoDto extends RepresentationModel<BoletimInformativoDto> {
    private UUID id;
    private String edicao;
    private LocalDate dataPublicacao;
    private Instant dataAtualizacao;
    private Instant dataCadastro;
    private List<ArtigoDto> artigos = new ArrayList<>();
    private List<CursoDto> cursos = new ArrayList<>();
    private List<EventoDto> eventos = new ArrayList<>();
    private List<NoticiaDto> noticias = new ArrayList<>();
    private List<VideoDto> videos = new ArrayList<>();

    public BoletimInformativoDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Instant getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Instant dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Instant getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Instant dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List<ArtigoDto> getArtigos() {
        return artigos;
    }

    public void setArtigos(List<ArtigoDto> artigos) {
        this.artigos = artigos;
    }

    public List<CursoDto> getCursos() {
        return cursos;
    }

    public void setCursos(List<CursoDto> cursos) {
        this.cursos = cursos;
    }

    public List<EventoDto> getEventos() {
        return eventos;
    }

    public void setEventos(List<EventoDto> eventos) {
        this.eventos = eventos;
    }

    public List<NoticiaDto> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<NoticiaDto> noticias) {
        this.noticias = noticias;
    }

    public List<VideoDto> getVideos() {
        return videos;
    }

    public void setVideos(List<VideoDto> videos) {
        this.videos = videos;
    }
}
