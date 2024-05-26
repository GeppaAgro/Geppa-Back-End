package com.geppa.BoletinsInformativos.domain.useCases.newsletter;

import com.geppa.BoletinsInformativos.domain.classes.InscricaoNewsletter;
import com.geppa.BoletinsInformativos.infrastructure.email.Email;
import com.geppa.BoletinsInformativos.infrastructure.gateways.GatewayInscricaoNewsletterRepositorio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnvioEmails {

    private final GatewayInscricaoNewsletterRepositorio gatewayInscricaoNewsletterRepositorio;
    private final Email emailService;

    public EnvioEmails(GatewayInscricaoNewsletterRepositorio gatewayInscricaoNewsletterRepositorio, Email emailService) {
        this.gatewayInscricaoNewsletterRepositorio = gatewayInscricaoNewsletterRepositorio;
        this.emailService = emailService;
    }

    @Async
    public void executar(String body) {
        int pagina = 0;
        int tamanhoPagina = 50;
        Pageable pageable = PageRequest.of(pagina, tamanhoPagina);

        while (true) {
            Page<InscricaoNewsletter> inscricoes = gatewayInscricaoNewsletterRepositorio.buscarAtivos(pageable);

            if (!inscricoes.hasContent()) {
                break;
            }

            List<String> emails = new ArrayList<>();
            for (InscricaoNewsletter inscricao : inscricoes.getContent()) {
                emails.add(inscricao.getEmail());
            }

            emailService.sendEmail(emails.toArray(new String[0]), body);

            pagina++;
            pageable = PageRequest.of(pagina, tamanhoPagina);
        }
    }
}
