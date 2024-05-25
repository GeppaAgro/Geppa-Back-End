package com.geppa.BoletinsInformativos.infrastructure.gateways;

import com.geppa.BoletinsInformativos.domain.classes.BoletimInformativo;
import com.geppa.BoletinsInformativos.domain.exceptions.MapperExcecao;
import com.geppa.BoletinsInformativos.domain.exceptions.ValidacaoTagNaoEncontradaExcecao;
import com.geppa.BoletinsInformativos.infrastructure.model.AutorModel;
import com.geppa.BoletinsInformativos.infrastructure.model.BoletimInformativoModel;
import com.geppa.BoletinsInformativos.infrastructure.model.IndicadorModel;
import com.geppa.BoletinsInformativos.infrastructure.model.TagModel;
import com.geppa.BoletinsInformativos.infrastructure.model.conteudos.*;
import com.geppa.BoletinsInformativos.infrastructure.persistencia.*;
import com.geppa.BoletinsInformativos.util.mapper.Mapper;
import com.geppa.BoletinsInformativos.util.enums.messages.MensagensExcecao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GatewayBoletimRepositorio {

    private final BoletimInformativoRepositorio boletimInformativoRepositorio;
    private final TagRepositorio tagRepositorio;
    private final IndicadoresRepositorio indicadorRepositorio;
    private final ConteudoRepositorio conteudoRepositorio;
    private final AutorRepositorio autorRepositorio;

    public GatewayBoletimRepositorio(BoletimInformativoRepositorio boletimInformativoRepositorio,
                                     TagRepositorio tagRepositorio,
                                     IndicadoresRepositorio indicadorRepositorio,
                                     ConteudoRepositorio conteudoRepositorio,
                                     AutorRepositorio autorRepositorio) {
        this.boletimInformativoRepositorio = boletimInformativoRepositorio;
        this.tagRepositorio = tagRepositorio;
        this.indicadorRepositorio = indicadorRepositorio;
        this.conteudoRepositorio = conteudoRepositorio;
        this.autorRepositorio = autorRepositorio;
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

    public BoletimInformativo salvar(BoletimInformativo boletimInformativo) {
        BoletimInformativoModel boletimInformativoModel = Mapper.parseObject(boletimInformativo, BoletimInformativoModel.class);
        associarTagsConteudos(boletimInformativoModel);

        BoletimInformativoModel boletimInformativoSalvo = boletimInformativoRepositorio.save(boletimInformativoModel);

        associarConteudos(boletimInformativoSalvo);
        associarIndicadores(boletimInformativoSalvo);
        associarAutoresArtigo(boletimInformativoSalvo.getArtigos());

        return Mapper.parseObject(boletimInformativoSalvo, BoletimInformativo.class);
    }


    private void associarTagsConteudos(BoletimInformativoModel boletimInformativo) {
        List<ConteudoModel> conteudos = boletimInformativo.getConteudos();
        for (ConteudoModel conteudo : conteudos) {
            List<TagModel> tags = conteudo.getTags();
            for (TagModel tag : tags) {
                List<TagModel> tagsEncontradas = tagRepositorio.consultarPorNome(tag.getNome().toLowerCase());
                if (tagsEncontradas.isEmpty()) {
                    throw new ValidacaoTagNaoEncontradaExcecao(tag.getNome());
                }
                TagModel tagComAssociacao = tagsEncontradas.get(0);
                conteudo.substituirInstanciaTag(tag, tagComAssociacao);
            }
        }
    }

    private void associarIndicadores(BoletimInformativoModel boletimInformativoModel) {
        List<IndicadorModel> indicadoresParaAssociar = boletimInformativoModel.getIndicadores();
        for (IndicadorModel indicador : indicadoresParaAssociar) {
            indicador.setBoletimInformativo(boletimInformativoModel);
            indicadorRepositorio.save(indicador);
        }
    }

    private void associarConteudos(BoletimInformativoModel boletimInformativoModel) {
        List<ConteudoModel> conteudosParaAssociar = boletimInformativoModel.getConteudos();
        for (ConteudoModel conteudo : conteudosParaAssociar) {
            conteudo.setBoletimInformativo(boletimInformativoModel);
            conteudoRepositorio.save(conteudo);
        }
    }

    private void associarAutoresArtigo(List<ArtigoModel> artigosParaAssociar) {
        if (artigosParaAssociar.isEmpty()) return;
        for (ArtigoModel artigo : artigosParaAssociar) {
            List<AutorModel> autores = artigo.getAutores();
            for (AutorModel autor : autores) {
                autor.setArtigo(artigo);
                autorRepositorio.save(autor);
            }
        }
    }
}

