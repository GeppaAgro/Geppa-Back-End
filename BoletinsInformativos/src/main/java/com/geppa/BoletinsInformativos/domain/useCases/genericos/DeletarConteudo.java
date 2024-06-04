
package com.geppa.BoletinsInformativos.domain.useCases.genericos;

import com.geppa.BoletinsInformativos.domain.exceptions.ConteudoNaoEncontradoExcecao;
import com.geppa.BoletinsInformativos.infrastructure.gateways.GatewayGenericoRepositorio;
import com.geppa.BoletinsInformativos.infrastructure.gateways.GatewayRepositoryGenericoFactory;
import com.geppa.BoletinsInformativos.util.ConverteStringUUID;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DeletarConteudo {

    private final GatewayRepositoryGenericoFactory gatewayFactory;

    public DeletarConteudo(GatewayRepositoryGenericoFactory gatewayFactory) {
        this.gatewayFactory = gatewayFactory;
    }

    public <T> void executar(String hash, Class<T> clazz) {
        UUID uuid = ConverteStringUUID.converter(hash);

        GatewayGenericoRepositorio<T> gatewayGenericoRepositorio = gatewayFactory.getGatewayFor(clazz);

        Optional<T> conteudoOptional = gatewayGenericoRepositorio.buscarPorHash(uuid);
        if (conteudoOptional.isEmpty()) {
            throw new ConteudoNaoEncontradoExcecao(hash);
        }
        gatewayGenericoRepositorio.deletar(conteudoOptional.get());
    }
}
