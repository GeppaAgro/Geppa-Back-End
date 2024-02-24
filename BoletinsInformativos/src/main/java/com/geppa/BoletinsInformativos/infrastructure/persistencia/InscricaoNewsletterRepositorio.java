package com.geppa.BoletinsInformativos.infrastructure.persistencia;

import com.geppa.BoletinsInformativos.infrastructure.model.InscricaoNewsletterModel;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InscricaoNewsletterRepositorio extends RepositorioGenerico<InscricaoNewsletterModel> {
    @Override
    default Class<InscricaoNewsletterModel> getClasseModelo() {
        return InscricaoNewsletterModel.class;
    }

    @Override
    default Optional<InscricaoNewsletterModel> buscarDuplicado(InscricaoNewsletterModel objeto) {
        return findByEmail(objeto.getEmail());
    }

    Optional<InscricaoNewsletterModel> findByEmail(String email);
}
