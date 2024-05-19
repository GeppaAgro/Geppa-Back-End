package com.geppa.BoletinsInformativos.infrastructure.persistencia.conteudos;

import com.geppa.BoletinsInformativos.infrastructure.model.conteudos.CursoModel;
import com.geppa.BoletinsInformativos.infrastructure.persistencia.RepositorioGenerico;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepositorio extends RepositorioGenerico<CursoModel> {

    default Class<CursoModel> getClasseModelo() {
        return CursoModel.class;
    }
}
