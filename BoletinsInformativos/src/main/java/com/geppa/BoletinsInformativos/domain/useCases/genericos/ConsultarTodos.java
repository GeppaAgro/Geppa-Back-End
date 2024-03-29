package com.geppa.BoletinsInformativos.domain.useCases.genericos;

import com.geppa.BoletinsInformativos.application.dtos.filters.FiltroGenericoDto;
import com.geppa.BoletinsInformativos.domain.exceptions.DadosNaoEncontradosExcecao;
import com.geppa.BoletinsInformativos.infrastructure.gateways.GatewayGenericoRepositorio;
import com.geppa.BoletinsInformativos.infrastructure.gateways.GatewayRepositoryGenericoFactory;
import com.geppa.BoletinsInformativos.infrastructure.specifications.SpecificationFiltroGenerico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ConsultarTodos {
    private final GatewayRepositoryGenericoFactory gatewayFactory;

    public ConsultarTodos(GatewayRepositoryGenericoFactory gatewayFactory) {
        this.gatewayFactory = gatewayFactory;
    }

    public <T> Page<T> executar(Pageable pageable, FiltroGenericoDto filtro, Class<T> tipoConteudo) {
        GatewayGenericoRepositorio<T> gatewayGenericoRepositorio = gatewayFactory.getGatewayFor(tipoConteudo);
        SpecificationFiltroGenerico<T> specificationFiltroGenerico = new SpecificationFiltroGenerico<>(filtro);
        Page<T> resultado = gatewayGenericoRepositorio.buscarTodosComPaginacaoEFiltro(pageable, specificationFiltroGenerico);
        if (!resultado.hasContent()) {
            throw new DadosNaoEncontradosExcecao(tipoConteudo.getSimpleName());
        }
        return resultado;
    }
}
