package com.geppa.BoletinsInformativos.infrastructure.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface RepositorioGenerico<T> extends JpaRepository<T, UUID>, JpaSpecificationExecutor<T> {
}
