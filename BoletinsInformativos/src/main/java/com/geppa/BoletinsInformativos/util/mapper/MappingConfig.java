package com.geppa.BoletinsInformativos.util.mapper;

import com.geppa.BoletinsInformativos.application.dtos.retorno.conteudos.*;
import com.geppa.BoletinsInformativos.domain.classes.conteudos.*;
import com.geppa.BoletinsInformativos.infrastructure.model.conteudos.*;

import java.util.HashMap;
import java.util.Map;

public class MappingConfig {

    public static final Map<Class<?>, Class<?>> MAPPING_DOMAIN_MODEL = new HashMap<>();
    public static final Map<Class<?>, Class<?>> MAPPING_DOMAIN_DTO = new HashMap<>();

    static {
        MAPPING_DOMAIN_MODEL.put(ArtigoModel.class, Artigo.class);
        MAPPING_DOMAIN_MODEL.put(CursoModel.class, Curso.class);
        MAPPING_DOMAIN_MODEL.put(EventoModel.class, Evento.class);
        MAPPING_DOMAIN_MODEL.put(NoticiaModel.class, Noticia.class);
        MAPPING_DOMAIN_MODEL.put(VideoModel.class, Video.class);

        MAPPING_DOMAIN_DTO.put(Artigo.class, ArtigoDto.class);
        MAPPING_DOMAIN_DTO.put(Curso.class, CursoDto.class);
        MAPPING_DOMAIN_DTO.put(Evento.class, EventoDto.class);
        MAPPING_DOMAIN_DTO.put(Noticia.class, NoticiaDto.class);
        MAPPING_DOMAIN_DTO.put(Video.class, VideoDto.class);
    }

}
