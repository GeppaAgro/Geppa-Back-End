package com.geppa.BoletinsInformativos.domain.useCases.newsletter;

import com.geppa.BoletinsInformativos.domain.classes.InscricaoNewsletter;
import com.geppa.BoletinsInformativos.domain.exceptions.newsletter.InscricaoJaCanceladaExcecao;
import com.geppa.BoletinsInformativos.domain.exceptions.newsletter.InscricaoNaoEncontradoExcecao;
import com.geppa.BoletinsInformativos.infrastructure.gateways.GatewayInscricaoNewsletterRepositorio;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;


@Service
public class CancelarInscricao {

    private final GatewayInscricaoNewsletterRepositorio gatewayInscricaoNewsletterRepositorio;

    public CancelarInscricao(GatewayInscricaoNewsletterRepositorio gatewayInscricaoNewsletterRepositorio) {
        this.gatewayInscricaoNewsletterRepositorio = gatewayInscricaoNewsletterRepositorio;
    }

    public InscricaoNewsletter executar(String email) {
        Optional<InscricaoNewsletter> inscricaoNewsletter = gatewayInscricaoNewsletterRepositorio.buscarPorEmail(email);

        if (inscricaoNewsletter.isEmpty()) {
            throw new InscricaoNaoEncontradoExcecao(email);
        }

        if (!inscricaoNewsletter.get().isAtivo()) {
            throw new InscricaoJaCanceladaExcecao(email);
        }

        inscricaoNewsletter.get().setAtivo(false);
        inscricaoNewsletter.get().setDataAtualizacao(Instant.now());
        return gatewayInscricaoNewsletterRepositorio.salvar(inscricaoNewsletter.get());
    }

}
