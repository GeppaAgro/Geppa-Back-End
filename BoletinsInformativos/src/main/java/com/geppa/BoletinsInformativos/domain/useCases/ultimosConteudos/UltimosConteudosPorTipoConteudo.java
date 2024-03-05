package com.geppa.BoletinsInformativos.domain.useCases.ultimosConteudos;

import com.geppa.BoletinsInformativos.application.dtos.filters.FiltroGenericoDto;
import com.geppa.BoletinsInformativos.domain.classes.conteudos.Conteudo;
import com.geppa.BoletinsInformativos.domain.useCases.genericos.ConsultarTodos;
import com.geppa.BoletinsInformativos.util.ConteudosTypesScanner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Set;


@Service
public class UltimosConteudosPorTipoConteudo {

    private final ConsultarTodos consultarTodos;
    private final ConteudosTypesScanner conteudosTypesScanner;

    public UltimosConteudosPorTipoConteudo(ConsultarTodos consultarTodos, ConteudosTypesScanner conteudosTypesScanner) {
        this.consultarTodos = consultarTodos;
        this.conteudosTypesScanner = conteudosTypesScanner;
    }

    public HashMap<String, List<Conteudo>> executar(int quantidade) {

        Set<Class<?>> tiposConteudo = conteudosTypesScanner.getTiposConteudo();

        HashMap<String, List<Conteudo>> ultimosConteudos = new HashMap<>();

        Pageable pageable = PageRequest.of(0, quantidade, Sort.by(Sort.Direction.DESC, "dataCadastro"));
        FiltroGenericoDto filtro = new FiltroGenericoDto();
        for (Class<?> tipoConteudo : tiposConteudo) {

            Page<Conteudo> conteudos = (Page<Conteudo>) consultarTodos.executar(pageable, filtro, tipoConteudo);

            ultimosConteudos.put(tipoConteudo.getSimpleName(), conteudos.getContent());
        }

        return ultimosConteudos;

    }


}
