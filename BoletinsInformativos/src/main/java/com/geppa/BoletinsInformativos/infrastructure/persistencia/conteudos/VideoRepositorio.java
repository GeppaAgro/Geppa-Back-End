package com.geppa.BoletinsInformativos.infrastructure.persistencia.conteudos;

import com.geppa.BoletinsInformativos.infrastructure.model.conteudos.VideoModel;
import com.geppa.BoletinsInformativos.infrastructure.persistencia.RepositorioGenerico;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepositorio extends RepositorioGenerico<VideoModel> {

    default Class<VideoModel> getClasseModelo() {
        return VideoModel.class;
    }
}
