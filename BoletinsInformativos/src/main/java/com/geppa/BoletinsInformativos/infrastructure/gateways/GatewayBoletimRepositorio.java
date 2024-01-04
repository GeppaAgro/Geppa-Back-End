package com.geppa.BoletinsInformativos.infrastructure.gateways;

import com.geppa.BoletinsInformativos.domain.classes.BoletimInformativo;
import com.geppa.BoletinsInformativos.domain.exceptions.MapperExcecao;
import com.geppa.BoletinsInformativos.infrastructure.persistencia.BoletimRepository;
import com.geppa.BoletinsInformativos.util.mapper.Mapper;
import com.geppa.BoletinsInformativos.util.messages.MensagensExcecao;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GatewayBoletimRepositorio {

    private final BoletimRepository boletimRepository;

    public GatewayBoletimRepositorio(BoletimRepository boletimRepository) {
        this.boletimRepository = boletimRepository;
    }

    public Optional<BoletimInformativo> buscarPorEdicao(String edicao) {
        return boletimRepository.buscarPorEdicao(edicao)
                .map(boletimInformativoModel -> {
                    try {
                        return Mapper.parseObject(boletimInformativoModel, BoletimInformativo.class);
                    } catch (Exception e) {
                        throw new MapperExcecao(MensagensExcecao.FALHA_CONVERSAO_MODELO_DOMINIO.getMensagem());
                    }
                });
    }

}
