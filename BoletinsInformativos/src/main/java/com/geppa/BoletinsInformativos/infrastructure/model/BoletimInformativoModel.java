package com.geppa.BoletinsInformativos.infrastructure.model;

import com.geppa.BoletinsInformativos.infrastructure.model.conteudos.*;
import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "boletins_informativos")
public class BoletimInformativoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid2")
    @Column(name = "bol_id", columnDefinition = "uuid")
    private UUID id;

    @Column(name = "bol_edicao")
    private String edicao;

    @Column(name = "bol_data_publicacao")
    private LocalDate dataPublicacao;

    @Column(name = "bol_data_atualizacao")
    private Instant dataAtualizacao;

    @OneToMany(mappedBy = "boletimInformativo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ArtigoModel> artigos;

    @OneToMany(mappedBy = "boletimInformativo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CursoModel> cursos;

    @OneToMany(mappedBy = "boletimInformativo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<EventoModel> eventos;

    @OneToMany(mappedBy = "boletimInformativo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<NoticiaModel> noticias;

    @OneToMany(mappedBy = "boletimInformativo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VideoModel> videos;

    public BoletimInformativoModel() {
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

    public List<ArtigoModel> getArtigos() {
        return artigos;
    }

    public void setArtigos(List<ArtigoModel> artigos) {
        this.artigos = artigos;
    }

    public List<CursoModel> getCursos() {
        return cursos;
    }

    public void setCursos(List<CursoModel> cursos) {
        this.cursos = cursos;
    }

    public List<EventoModel> getEventos() {
        return eventos;
    }

    public void setEventos(List<EventoModel> eventos) {
        this.eventos = eventos;
    }

    public List<NoticiaModel> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<NoticiaModel> noticias) {
        this.noticias = noticias;
    }

    public List<VideoModel> getVideos() {
        return videos;
    }

    public void setVideos(List<VideoModel> videos) {
        this.videos = videos;
    }
}