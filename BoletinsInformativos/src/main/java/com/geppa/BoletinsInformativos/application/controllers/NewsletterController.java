package com.geppa.BoletinsInformativos.application.controllers;

import com.geppa.BoletinsInformativos.application.dtos.cadastro.InscricaoNewsletterCadastroDto;
import com.geppa.BoletinsInformativos.application.dtos.cadastro.NewsletterPublicacaoDto;
import com.geppa.BoletinsInformativos.application.dtos.padrao.RetornoPadraoDto;
import com.geppa.BoletinsInformativos.application.dtos.retorno.InscricaoNewsletterDto;
import com.geppa.BoletinsInformativos.domain.classes.InscricaoNewsletter;
import com.geppa.BoletinsInformativos.domain.useCases.genericos.CadastrarComAtributoAtivo;
import com.geppa.BoletinsInformativos.domain.useCases.newsletter.CancelarInscricao;
import com.geppa.BoletinsInformativos.domain.useCases.newsletter.EnvioEmails;
import com.geppa.BoletinsInformativos.util.enums.messages.MensagensRetorno;
import com.geppa.BoletinsInformativos.util.mapper.Mapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/newsletters")
public class NewsletterController {

    private final CadastrarComAtributoAtivo cadastroEmail;
    private final CancelarInscricao cancelarInscricaoNewsletter;
    private final EnvioEmails envioEmails;

    public NewsletterController(CadastrarComAtributoAtivo cadastroEmail,
                                CancelarInscricao cancelarInscricaoNewsletter,
                                EnvioEmails envioEmails) {
        this.cadastroEmail = cadastroEmail;
        this.cancelarInscricaoNewsletter = cancelarInscricaoNewsletter;
        this.envioEmails = envioEmails;
    }

    @PostMapping("/inscricao")
    public ResponseEntity<RetornoPadraoDto> cadastrarEmail(@RequestBody InscricaoNewsletterCadastroDto newsletterCadastroDto) {
        InscricaoNewsletter inscricao = cadastroEmail.executar(Mapper.parseObject(newsletterCadastroDto, InscricaoNewsletter.class), InscricaoNewsletter.class);

        RetornoPadraoDto resposta = new RetornoPadraoDto(MensagensRetorno.SUCESSO_INSCRICAO_NEWSLETTER.getMensagem(), 201,
                Mapper.parseObject(inscricao, InscricaoNewsletterDto.class));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(inscricao.getId()).toUri();
        return ResponseEntity.created(location).body(resposta);
    }

    @DeleteMapping("/cancelar-inscricao/{email}")
    public ResponseEntity<RetornoPadraoDto> cancelarInscricao(@PathVariable String email) {
        InscricaoNewsletter inscricaoNewsletterCancelata = cancelarInscricaoNewsletter.executar(email);
        RetornoPadraoDto resposta = new RetornoPadraoDto(MensagensRetorno.SUCESSO_CANCELAMENTO_NEWSLETTER.getMensagem(), 200,
                Mapper.parseObject(inscricaoNewsletterCancelata, InscricaoNewsletterDto.class));
        return ResponseEntity.ok(resposta);
    }

    @PostMapping("/publicar")
    public ResponseEntity<RetornoPadraoDto> publicarBoletim(@RequestBody NewsletterPublicacaoDto newsletterDto) {
        envioEmails.executar(newsletterDto.getBody());

        RetornoPadraoDto resposta = new RetornoPadraoDto(MensagensRetorno.SUCESSO_ENVIO_EMAILS.getMensagem(),
                200, null);

        return ResponseEntity.ok(resposta);
    }
}
