package com.geppa.BoletinsInformativos.domain.useCases.artigo;

import com.geppa.BoletinsInformativos.domain.classes.conteudos.Artigo;
import com.geppa.BoletinsInformativos.domain.exceptions.ConteudoNaoEncontradoExcecao;
import com.geppa.BoletinsInformativos.domain.exceptions.HashInvalidaExcecao;
import com.geppa.BoletinsInformativos.infrastructure.gateways.ArtigoRepositoryGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ArtigoConsultaPorHash {

    private final ArtigoRepositoryGateway artigoRepositoryGateway;

    public ArtigoConsultaPorHash(ArtigoRepositoryGateway artigoRepositoryGateway) {
        this.artigoRepositoryGateway = artigoRepositoryGateway;
    }

    public Artigo executar(String hash) {
        UUID uuid;
        try {
            uuid = UUID.fromString(hash);
        } catch (Exception e) {
            throw new HashInvalidaExcecao(hash);
        }

        return artigoRepositoryGateway.buscarPorHash(uuid)
                .orElseThrow(() -> new ConteudoNaoEncontradoExcecao("Artigo", hash));
    }
}
