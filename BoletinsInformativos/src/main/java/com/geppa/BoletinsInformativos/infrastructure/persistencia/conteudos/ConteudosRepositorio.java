package com.geppa.BoletinsInformativos.infrastructure.persistencia.conteudos;

import com.geppa.BoletinsInformativos.infrastructure.model.conteudos.ConteudoModel;
import com.geppa.BoletinsInformativos.infrastructure.persistencia.RepositorioGenerico;
import org.springframework.stereotype.Repository;

@Repository
public interface ConteudosRepositorio extends RepositorioGenerico<ConteudoModel> {

    default Class<ConteudoModel> getClasseModelo() {
        return ConteudoModel.class;
    }

}
