package com.geppa.BoletinsInformativos.infrastructure.gateways;

import com.geppa.BoletinsInformativos.domain.exceptions.BuscaInvalidaExcecao;
import com.geppa.BoletinsInformativos.domain.exceptions.MapperExcecao;
import com.geppa.BoletinsInformativos.domain.exceptions.OrdenacaaoInvalidaExcecao;
import com.geppa.BoletinsInformativos.util.mapper.Mapper;
import com.geppa.BoletinsInformativos.util.messages.MensagensExcecao;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mapping.PropertyReferenceException;

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
                        throw new MapperExcecao(MensagensExcecao.FALHA_CONVERSAO_MODELO_DOMINIO.getMensagem());
                    }
                });
    }

    public Page<T> buscarTodosComPaginacao(Pageable pageable) {
        try{
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
}