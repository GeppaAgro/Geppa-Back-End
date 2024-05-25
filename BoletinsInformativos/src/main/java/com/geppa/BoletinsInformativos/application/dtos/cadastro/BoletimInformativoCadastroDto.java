package com.geppa.BoletinsInformativos.application.dtos.cadastro;

import com.geppa.BoletinsInformativos.application.dtos.cadastro.conteudos.*;
import org.springframework.hateoas.RepresentationModel;

import java.util.ArrayList;
import java.util.List;

public class BoletimInformativoCadastroDto extends RepresentationModel<BoletimInformativoCadastroDto> {
    private List<ArtigoCadastroDto> artigos = new ArrayList<>();
    private List<CursoCadastroDto> cursos = new ArrayList<>();
    private List<EventoCadastroDto> eventos = new ArrayList<>();
    private List<NoticiaCadastroDto> noticias = new ArrayList<>();
    private List<VideoCadastroDto> videos = new ArrayList<>();
    private List<IndicadorCadastroDto> indicadores = new ArrayList<>();

    public List<ArtigoCadastroDto> getArtigos() {
        return artigos;
    }

    public void setArtigos(List<ArtigoCadastroDto> artigos) {
        this.artigos = artigos;
    }

    public List<CursoCadastroDto> getCursos() {
        return cursos;
    }

    public void setCursos(List<CursoCadastroDto> cursos) {
        this.cursos = cursos;
    }

    public List<EventoCadastroDto> getEventos() {
        return eventos;
    }

    public void setEventos(List<EventoCadastroDto> eventos) {
        this.eventos = eventos;
    }

    public List<NoticiaCadastroDto> getNoticias() {
        return noticias;
    }

    public void setNoticias(List<NoticiaCadastroDto> noticias) {
        this.noticias = noticias;
    }

    public List<VideoCadastroDto> getVideos() {
        return videos;
    }

    public void setVideos(List<VideoCadastroDto> videos) {
        this.videos = videos;
    }

    public List<IndicadorCadastroDto> getIndicadores() {
        return indicadores;
    }

    public void setIndicadores(List<IndicadorCadastroDto> indicadores) {
        this.indicadores = indicadores;
    }
}
