package com.geppa.BoletinsInformativos.infrastructure.gateways;

import com.geppa.BoletinsInformativos.domain.classes.conteudos.Artigo;
import com.geppa.BoletinsInformativos.infrastructure.persistencia.ArtigoRepository;
import com.geppa.BoletinsInformativos.util.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ArtigoRepositoryGateway {

    private final ArtigoRepository repository;

    public ArtigoRepositoryGateway(ArtigoRepository repository) {
        this.repository = repository;
    }

    public Optional<Artigo> buscarPorHash(UUID hash) {
        return repository.findById(hash)
                .map(artigoModel -> Mapper.parseObject(artigoModel, Artigo.class));
    }
}
