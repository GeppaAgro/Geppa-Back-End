package com.geppa.BoletinsInformativos.domain.useCases.genericos;

import com.geppa.BoletinsInformativos.infrastructure.gateways.GatewayGenericoRepositorio;
import com.geppa.BoletinsInformativos.infrastructure.gateways.GatewayRepositoryGenericoFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ConsultarTodos {
    private final GatewayRepositoryGenericoFactory gatewayFactory;

    public ConsultarTodos(GatewayRepositoryGenericoFactory gatewayFactory) {
        this.gatewayFactory = gatewayFactory;
    }

    public <T> Page<T> executar(Pageable pageable, Class<T> tipoConteudo) {
        GatewayGenericoRepositorio<T> gatewayGenericoRepositorio = gatewayFactory.getGatewayFor(tipoConteudo);
        return gatewayGenericoRepositorio.buscarTodosComPaginacao(pageable);
    }
}
