
package com.geppa.BoletinsInformativos.domain.useCases.Indicador;

import com.geppa.BoletinsInformativos.domain.classes.Indicador;
import com.geppa.BoletinsInformativos.domain.exceptions.ConteudoNaoEncontradoExcecao;
import com.geppa.BoletinsInformativos.infrastructure.gateways.GatewayIndicador;
import com.geppa.BoletinsInformativos.util.ConverteStringUUID;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DeletarIndicador {

    private final GatewayIndicador gatewayIndicador;

    public DeletarIndicador(GatewayIndicador gatewayIndicador) {
        this.gatewayIndicador = gatewayIndicador;
    }

    public void executar(String id) {
        UUID uuid = ConverteStringUUID.converter(id);

        Optional<Indicador> indicadorOptional = gatewayIndicador.buscarPorId(uuid);
        if (indicadorOptional.isEmpty()) {
            throw new ConteudoNaoEncontradoExcecao(id);
        }
        indicadorOptional.get().setBoletimInformativo(null);
        gatewayIndicador.deletar(indicadorOptional.get());
    }
}
