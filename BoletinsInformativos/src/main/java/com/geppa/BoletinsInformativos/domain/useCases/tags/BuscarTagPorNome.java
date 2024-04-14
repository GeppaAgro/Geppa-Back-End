package com.geppa.BoletinsInformativos.domain.useCases.tags;

import com.geppa.BoletinsInformativos.domain.classes.Tag;
import com.geppa.BoletinsInformativos.domain.exceptions.BuscaInvalidaExcecao;
import com.geppa.BoletinsInformativos.infrastructure.gateways.GatewayTagRepositorio;
import com.geppa.BoletinsInformativos.util.enums.messages.MensagensExcecao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarTagPorNome {

    private final GatewayTagRepositorio gatewayTagRepositorio;

    public BuscarTagPorNome(GatewayTagRepositorio gatewayTagRepositorio) {
        this.gatewayTagRepositorio = gatewayTagRepositorio;
    }

    public List<Tag> executar(String nome) {

        if (nome == null || nome.isEmpty() || !nome.matches("^[a-zA-Z0-9 ]*$"))
            throw new BuscaInvalidaExcecao(MensagensExcecao.NOME_TAG_INVALIDO.getMensagem());

        List<Tag> tags = gatewayTagRepositorio.consultarPorNome(nome);
        if (tags.isEmpty())
            throw new BuscaInvalidaExcecao(MensagensExcecao.TAG_NAO_ENCONTRADA.getMensagem());

        return tags;
    }

}
