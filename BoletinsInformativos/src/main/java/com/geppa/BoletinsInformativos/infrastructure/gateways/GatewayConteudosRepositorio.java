package com.geppa.BoletinsInformativos.infrastructure.gateways;

import com.geppa.BoletinsInformativos.domain.classes.conteudos.Conteudo;
import com.geppa.BoletinsInformativos.domain.exceptions.BuscaInvalidaExcecao;
import com.geppa.BoletinsInformativos.domain.exceptions.MapperExcecao;
import com.geppa.BoletinsInformativos.domain.exceptions.OrdenacaaoInvalidaExcecao;
import com.geppa.BoletinsInformativos.infrastructure.model.conteudos.ConteudoModel;
import com.geppa.BoletinsInformativos.infrastructure.persistencia.conteudos.ConteudosRepositorio;
import com.geppa.BoletinsInformativos.util.enums.messages.MensagensExcecao;
import com.geppa.BoletinsInformativos.util.mapper.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.stereotype.Service;
@Service
public class GatewayConteudosRepositorio {

    private final ConteudosRepositorio conteudosRepositorio;

    public GatewayConteudosRepositorio(ConteudosRepositorio conteudosRepositorio) {
        this.conteudosRepositorio = conteudosRepositorio;
    }

    public Page<Conteudo> buscarConteudos(Pageable pageable, Specification<ConteudoModel> filtro) {
        try {
            return conteudosRepositorio.findAll(filtro, pageable)
                    .map(conteudoModel -> {
                        try {
                            return Mapper.parseObject(conteudoModel, Conteudo.class);
                        } catch (Exception e) {
                            throw new MapperExcecao(MensagensExcecao.FALHA_CONVERSAO_MODELO_DOMINIO.getMensagem());
                        }
                    });
        } catch (PropertyReferenceException e) {
            throw new OrdenacaaoInvalidaExcecao(pageable.getSort().toString());
        } catch (Exception e) {
            throw new BuscaInvalidaExcecao();
        }
    }
}