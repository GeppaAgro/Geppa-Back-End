package com.geppa.BoletinsInformativos.infrastructure.gateways;

import com.geppa.BoletinsInformativos.domain.classes.BoletimInformativo;
import com.geppa.BoletinsInformativos.domain.exceptions.MapperExcecao;
import com.geppa.BoletinsInformativos.infrastructure.persistencia.BoletimInformativoRepositorio;
import com.geppa.BoletinsInformativos.util.mapper.Mapper;
import com.geppa.BoletinsInformativos.util.messages.MensagensExcecao;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GatewayBoletimRepositorio {

    private final BoletimInformativoRepositorio boletimInformativoRepositorio;

    public GatewayBoletimRepositorio(BoletimInformativoRepositorio boletimInformativoRepositorio) {
        this.boletimInformativoRepositorio = boletimInformativoRepositorio;
    }

    public Optional<BoletimInformativo> buscarPorEdicao(String edicao) {
        return boletimInformativoRepositorio.buscarPorEdicao(edicao)
                .map(boletimInformativoModel -> {
                    try {
                        return Mapper.parseObject(boletimInformativoModel, BoletimInformativo.class);
                    } catch (Exception e) {
                        throw new MapperExcecao(MensagensExcecao.FALHA_CONVERSAO_MODELO_DOMINIO.getMensagem());
                    }
                });
    }

}
