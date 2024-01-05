package com.geppa.BoletinsInformativos.domain.useCases.boletimInformativo;

import com.geppa.BoletinsInformativos.domain.classes.BoletimInformativo;
import com.geppa.BoletinsInformativos.domain.exceptions.BoletimNaoEncontradoExcecao;
import com.geppa.BoletinsInformativos.infrastructure.gateways.GatewayBoletimRepositorio;
import org.springframework.stereotype.Service;

@Service
public class ConsultaBoletimPorEdicao {

    private final GatewayBoletimRepositorio gatewayBoletimRepositorio;

    public ConsultaBoletimPorEdicao(GatewayBoletimRepositorio gatewayBoletimRepositorio) {
        this.gatewayBoletimRepositorio = gatewayBoletimRepositorio;
    }

    public BoletimInformativo executar(String edicao) {
        return gatewayBoletimRepositorio.buscarPorEdicao(edicao)
                .orElseThrow(() -> new BoletimNaoEncontradoExcecao(edicao));
    }

}
