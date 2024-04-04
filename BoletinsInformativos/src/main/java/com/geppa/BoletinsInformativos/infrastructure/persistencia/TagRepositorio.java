package com.geppa.BoletinsInformativos.infrastructure.persistencia;

import com.geppa.BoletinsInformativos.infrastructure.model.TagModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TagRepositorio extends RepositorioGenerico<TagModel> {

    @Query("SELECT t FROM TagModel t WHERE LOWER(t.nome) LIKE %?1%")
    List<TagModel> consultarPorNome(String nome);

    @Override
    default Class<TagModel> getClasseModelo() {
        return TagModel.class;
    }

    @Override
    default Optional<TagModel> buscarDuplicado(TagModel objeto) {
        return findByNome(objeto.getNome());
    }

    @Query("SELECT t FROM TagModel t WHERE LOWER(t.nome) = LOWER(?1)")
    Optional<TagModel> findByNome(String nome);
}
