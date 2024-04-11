package com.geppa.BoletinsInformativos.application.controllers;

import com.geppa.BoletinsInformativos.application.dtos.cadastro.InscricaoNewsletterCadastroDto;
import com.geppa.BoletinsInformativos.application.dtos.padrao.RetornoPadraoDto;
import com.geppa.BoletinsInformativos.application.dtos.retorno.InscricaoNewsletterDto;
import com.geppa.BoletinsInformativos.domain.classes.InscricaoNewsletter;
import com.geppa.BoletinsInformativos.domain.useCases.genericos.CadastrarComAtributoAtivo;
import com.geppa.BoletinsInformativos.domain.useCases.newsletter.CancelarInscricao;
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

    public NewsletterController(CadastrarComAtributoAtivo cadastroEmail, CancelarInscricao cancelarInscricaoNewsletter) {
        this.cadastroEmail = cadastroEmail;
        this.cancelarInscricaoNewsletter = cancelarInscricaoNewsletter;
    }

    @PostMapping("/inscricao")
    public ResponseEntity<RetornoPadraoDto> cadastrarEmail(@RequestBody InscricaoNewsletterCadastroDto newsletterCadastroDto) {
        InscricaoNewsletter inscricao = cadastroEmail.executar(Mapper.parseObject(newsletterCadastroDto, InscricaoNewsletter.class), InscricaoNewsletter.class);

        RetornoPadraoDto resposta = new RetornoPadraoDto(MensagensRetorno.SUCESSO_INSCRICAO_NEWSLETTER.getMensagem(), 201,
                Mapper.parseObject(inscricao, InscricaoNewsletterDto.class));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(inscricao.getId()).toUri();
        return ResponseEntity.created(location).body(resposta);
    }

    @DeleteMapping("/cancelar-inscricao")
    public ResponseEntity<RetornoPadraoDto> cancelarInscricao(@RequestBody InscricaoNewsletterCadastroDto newsletterDto) {
        InscricaoNewsletter inscricaoNewsletterCancelata = cancelarInscricaoNewsletter.executar(newsletterDto.getEmail());
        RetornoPadraoDto resposta = new RetornoPadraoDto(MensagensRetorno.SUCESSO_CANCELAMENTO_NEWSLETTER.getMensagem(), 200,
                Mapper.parseObject(inscricaoNewsletterCancelata, InscricaoNewsletterDto.class));
        return ResponseEntity.ok(resposta);
    }
}
