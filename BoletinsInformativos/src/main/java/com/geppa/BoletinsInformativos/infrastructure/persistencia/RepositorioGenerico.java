package com.geppa.BoletinsInformativos.infrastructure.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface RepositorioGenerico<T> extends JpaRepository<T, UUID>, JpaSpecificationExecutor<T> {
    default Class<T> getClasseModelo() {
        throw new UnsupportedOperationException("Método não implementado");
    }

    default Optional<T> buscarDuplicado(T objeto) {
        throw new UnsupportedOperationException("Método não implementado");
    }
}
