package com.geppa.BoletinsInformativos.domain.classes;

import com.geppa.BoletinsInformativos.domain.classes.conteudos.*;
import com.geppa.BoletinsInformativos.util.annotations.AutoPreenchimentoAtualizacao;
import com.geppa.BoletinsInformativos.util.annotations.AutoPreenchimentoCadastro;
import com.geppa.BoletinsInformativos.util.enums.TipoPreenchimento;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BoletimInformativo {
    private UUID id;
    private String edicao;
    private LocalDate dataPublicacao;

    @AutoPreenchimentoAtualizacao(TipoPreenchimento.INSTANT)
    private Instant dataAtualizacao;

    @AutoPreenchimentoCadastro(TipoPreenchimento.INSTANT)
    private Instant dataCadastro;

    @Valid
    private List<Artigo> artigos = new ArrayList<>();

    @Valid
    private List<Curso> cursos = new ArrayList<>();

    @Valid
    private List<Evento> eventos = new ArrayList<>();

    @NotNull(message = "{boletim.noticias.notNull}")
    @Size(min = 1, message = "{boletim.noticias.size}")
    @Valid
    private List<Noticia> noticias = new ArrayList<>();

    @Valid
    private List<Video> videos = new ArrayList<>();

    @NotNull(message = "{boletim.indicadores.notNull}")
    @Size(min = 1, message = "{boletim.indicadores.size}")
    private List<Indicador> indicadores = new ArrayList<>();

    public BoletimInformativo() {
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

    public List<Artigo> getArtigos() {
        return artigos;
    }

    public void setArtigos(List<Artigo> artigos) {
        this.artigos = artigos;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public List<Noticia> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public List<Indicador> getIndicadores() {
        return indicadores;
    }

    public void setIndicadores(List<Indicador> indicadores) {
        this.indicadores = indicadores;
    }
}
