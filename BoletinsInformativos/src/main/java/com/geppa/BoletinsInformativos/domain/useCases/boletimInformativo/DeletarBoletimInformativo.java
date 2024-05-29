package com.geppa.BoletinsInformativos.domain.useCases.boletimInformativo;

import com.geppa.BoletinsInformativos.domain.classes.BoletimInformativo;
import com.geppa.BoletinsInformativos.domain.exceptions.DelecaoInvalidaExcecao;
import com.geppa.BoletinsInformativos.infrastructure.gateways.GatewayBoletimRepositorio;
import com.geppa.BoletinsInformativos.util.enums.messages.MensagensExcecao;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeletarBoletimInformativo {

    private final GatewayBoletimRepositorio gatewayBoletimRepositorio;


    public DeletarBoletimInformativo(GatewayBoletimRepositorio gatewayBoletimRepositorio) {
        this.gatewayBoletimRepositorio = gatewayBoletimRepositorio;
    }

    public void executar(String edicao) {
        if (edicao == null || edicao.isEmpty())
            throw new DelecaoInvalidaExcecao(MensagensExcecao.BOLETIM_NAO_ENCONTRADO_EDICAO.getMensagem() + edicao);

        Optional<BoletimInformativo> boletimOptional = gatewayBoletimRepositorio.buscarPorEdicao(edicao.trim());
        if (boletimOptional.isEmpty()) {
            throw new DelecaoInvalidaExcecao(MensagensExcecao.BOLETIM_NAO_ENCONTRADO_EDICAO.getMensagem() + edicao);
        }

        gatewayBoletimRepositorio.deletar(boletimOptional.get());
    }

}
