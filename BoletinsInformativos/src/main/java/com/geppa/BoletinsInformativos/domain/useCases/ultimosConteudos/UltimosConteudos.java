package com.geppa.BoletinsInformativos.domain.useCases.ultimosConteudos;

import com.geppa.BoletinsInformativos.application.dtos.filters.FiltroGenericoDto;
import com.geppa.BoletinsInformativos.domain.classes.conteudos.Conteudo;
import com.geppa.BoletinsInformativos.infrastructure.gateways.GatewayConteudosRepositorio;
import com.geppa.BoletinsInformativos.infrastructure.model.conteudos.ConteudoModel;
import com.geppa.BoletinsInformativos.infrastructure.specifications.SpecificationFiltroGenerico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UltimosConteudos {

    private final GatewayConteudosRepositorio geatewayConteudosRepositorio;

    public UltimosConteudos(GatewayConteudosRepositorio geatewayConteudosRepositorio) {
        this.geatewayConteudosRepositorio = geatewayConteudosRepositorio;
    }

    public List<Conteudo> executar(int quantidade) {
        Pageable pageable = PageRequest.of(0, quantidade, Sort.by(Sort.Direction.DESC, "dataCadastro"));
        SpecificationFiltroGenerico<ConteudoModel> specificationFiltroGenerico = new SpecificationFiltroGenerico<>(new FiltroGenericoDto());
        Page<Conteudo> conteudos = geatewayConteudosRepositorio.buscarConteudos(pageable, specificationFiltroGenerico);

        return conteudos.getContent();
    }

}
