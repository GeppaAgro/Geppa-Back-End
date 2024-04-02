package com.geppa.BoletinsInformativos.infrastructure.gateways;

import com.geppa.BoletinsInformativos.domain.exceptions.BuscaInvalidaExcecao;
import com.geppa.BoletinsInformativos.domain.exceptions.MapperExcecao;
import com.geppa.BoletinsInformativos.domain.exceptions.OrdenacaaoInvalidaExcecao;
import com.geppa.BoletinsInformativos.infrastructure.persistencia.RepositorioGenerico;
import com.geppa.BoletinsInformativos.util.mapper.Mapper;
import com.geppa.BoletinsInformativos.util.enums.messages.MensagensExcecao;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.mapping.PropertyReferenceException;

import java.util.Optional;
import java.util.UUID;

public class GatewayGenericoRepositorio<T> {

    private final RepositorioGenerico<T> repository;
    private final Class<T> entityType;

    public GatewayGenericoRepositorio(RepositorioGenerico<T> repository, Class<T> classeDominio) {
        this.repository = repository;
        this.entityType = classeDominio;
    }

    public Optional<T> buscarPorHash(UUID hash) {
        return repository.findById(hash)
                .map(contentModel -> {
                    try {
                        return Mapper.parseObject(contentModel, entityType);
                    } catch (Exception e) {
                        throw new MapperExcecao(MensagensExcecao.FALHA_CONVERSAO_MODELO_DOMINIO.getMensagem());
                    }
                });
    }

    public Page<T> buscarTodosComPaginacaoEFiltro(Pageable pageable, Specification<T> filtro) {
        try {
            return repository.findAll(filtro, pageable)
                    .map(contentModel -> {
                        try {
                            return Mapper.parseObject(contentModel, entityType);
                        } catch (Exception e) {
                            throw new MapperExcecao(MensagensExcecao.FALHA_CONVERSAO_MODELO_DOMINIO.getMensagem());
                        }
                    });
        } catch (PropertyReferenceException e) {
            throw new OrdenacaaoInvalidaExcecao(pageable.getSort().toString());
        } catch (Exception e) {
            throw new BuscaInvalidaExcecao();
        }
    }

    public Page<T> buscarTodosComPaginacao(Pageable pageable) {
        try {
            return repository.findAll(pageable)
                    .map(contentModel -> {
                        try {
                            return Mapper.parseObject(contentModel, entityType);
                        } catch (Exception e) {
                            throw new MapperExcecao(MensagensExcecao.FALHA_CONVERSAO_MODELO_DOMINIO.getMensagem());
                        }
                    });
        } catch (PropertyReferenceException e) {
            throw new OrdenacaaoInvalidaExcecao(pageable.getSort().toString());
        } catch (Exception e) {
            throw new BuscaInvalidaExcecao();
        }
    }

    public T salvar(T objeto) {
        try {
            return Mapper.parseObject(repository.save(Mapper.parseObject(objeto, repository.getClasseModelo())), entityType);
        } catch (Exception e) {
            throw new MapperExcecao(MensagensExcecao.FALHA_CONVERSAO_MODELO_DOMINIO.getMensagem());
        }
    }

    public Optional<T> buscarDuplicado(T objeto) {
        return repository.buscarDuplicado(Mapper.parseObject(objeto, repository.getClasseModelo()))
                .map(contentModel -> {
                    try {
                        return Mapper.parseObject(contentModel, entityType);
                    } catch (Exception e) {
                        throw new MapperExcecao(MensagensExcecao.FALHA_CONVERSAO_MODELO_DOMINIO.getMensagem());
                    }
                });
    }


}