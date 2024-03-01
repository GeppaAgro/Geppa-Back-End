package com.geppa.BoletinsInformativos.domain.useCases.genericos;

import com.geppa.BoletinsInformativos.domain.exceptions.ConteudoNaoEncontradoExcecao;
import com.geppa.BoletinsInformativos.domain.exceptions.HashInvalidaExcecao;
import com.geppa.BoletinsInformativos.infrastructure.gateways.GatewayGenericoRepositorio;
import com.geppa.BoletinsInformativos.infrastructure.gateways.GatewayRepositoryGenericoFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ConsultaPorHash {

    private final GatewayRepositoryGenericoFactory gatewayFactory;

    public ConsultaPorHash(GatewayRepositoryGenericoFactory gatewayFactory) {
        this.gatewayFactory = gatewayFactory;
    }

    public <T> T executar(String hash, Class<T> clazz) {
        UUID uuid;
        try {
            uuid = UUID.fromString(hash);
        } catch (Exception e) {
            throw new HashInvalidaExcecao(hash);
        }

        GatewayGenericoRepositorio<T> gatewayGenericoRepositorio = gatewayFactory.getGatewayFor(clazz);
        return gatewayGenericoRepositorio.buscarPorHash(uuid)
                .orElseThrow(() -> new ConteudoNaoEncontradoExcecao(hash));
    }
}
