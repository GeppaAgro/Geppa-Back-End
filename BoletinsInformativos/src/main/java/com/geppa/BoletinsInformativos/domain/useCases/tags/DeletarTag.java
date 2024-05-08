package com.geppa.BoletinsInformativos.domain.useCases.tags;

import com.geppa.BoletinsInformativos.domain.classes.Tag;
import com.geppa.BoletinsInformativos.domain.exceptions.DelecaoInvalidaExcecao;
import com.geppa.BoletinsInformativos.domain.exceptions.TagEmUsoException;
import com.geppa.BoletinsInformativos.infrastructure.gateways.GatewayTagRepositorio;
import com.geppa.BoletinsInformativos.util.enums.messages.MensagensExcecao;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeletarTag {

    private final GatewayTagRepositorio gatewayTagRepositorio;


    public DeletarTag(GatewayTagRepositorio gatewayTagRepositorio) {
        this.gatewayTagRepositorio = gatewayTagRepositorio;
    }

    public void executar(String nome) {
        if (nome == null || nome.isEmpty())
            throw new DelecaoInvalidaExcecao(MensagensExcecao.NOME_TAG_INVALIDO.getMensagem());

        Optional<Tag> tagOptional = gatewayTagRepositorio.buscar(nome.trim());
        if (tagOptional.isEmpty()) {
            throw new DelecaoInvalidaExcecao(MensagensExcecao.TAG_NAO_ENCONTRADA.getMensagem());
        }

        verificaUtilizacaoDeTagPorConteudos(tagOptional.get());

        gatewayTagRepositorio.deletarPorNome(tagOptional.get());
    }

    private void verificaUtilizacaoDeTagPorConteudos(Tag tag) {
        Long quantidadeDeConteudos = gatewayTagRepositorio.verificaUtilizacaoDeTagPorConteudos(tag);
        if (quantidadeDeConteudos > 0) {
            throw new TagEmUsoException(quantidadeDeConteudos);
        }
    }


}
