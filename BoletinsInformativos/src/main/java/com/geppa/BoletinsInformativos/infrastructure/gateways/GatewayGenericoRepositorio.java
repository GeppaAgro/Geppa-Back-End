package com.geppa.BoletinsInformativos.infrastructure.gateways;

import com.geppa.BoletinsInformativos.domain.exceptions.MapperExcecao;
import com.geppa.BoletinsInformativos.util.mapper.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class GatewayGenericoRepositorio<T> {

    private final JpaRepository<T, UUID> repository;
    private final Class<T> entityType;

    public GatewayGenericoRepositorio(JpaRepository<T, UUID> repository, Class<T> classeDominio) {
        this.repository = repository;
        this.entityType = classeDominio;
    }

    public Optional<T> buscarPorHash(UUID hash) {
        return repository.findById(hash)
                .map(contentModel -> {
                    try {
                        return Mapper.parseObject(contentModel, entityType);
                    } catch (Exception e) {
                        throw new MapperExcecao();
                    }
                });
    }

    public List<T> buscarTodos() {
        return Mapper.parseListObjects(repository.findAll(), entityType);
    }
}