package com.geppa.BoletinsInformativos.infrastructure.persistencia;

import com.geppa.BoletinsInformativos.infrastructure.model.TagModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepositorio extends RepositorioGenerico<TagModel> {

    @Query("SELECT t FROM TagModel t WHERE LOWER(t.nome) LIKE %?1%")
    List<TagModel> consultarPorNome(String nome);
}
