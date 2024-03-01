package com.geppa.BoletinsInformativos.infrastructure.persistencia.conteudos;

import com.geppa.BoletinsInformativos.infrastructure.model.conteudos.ArtigoModel;
import com.geppa.BoletinsInformativos.infrastructure.persistencia.RepositorioGenerico;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtigoRepositorio extends RepositorioGenerico<ArtigoModel> {
}
