package com.geppa.BoletinsInformativos.infrastructure.persistencia.conteudos;

import com.geppa.BoletinsInformativos.infrastructure.model.conteudos.EventoModel;
import com.geppa.BoletinsInformativos.infrastructure.persistencia.RepositorioGenerico;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepositorio extends RepositorioGenerico<EventoModel> {

    default Class<EventoModel> getClasseModelo() {
        return EventoModel.class;
    }
}
