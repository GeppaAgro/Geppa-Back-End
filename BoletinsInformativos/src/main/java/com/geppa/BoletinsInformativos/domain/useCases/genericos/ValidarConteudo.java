package com.geppa.BoletinsInformativos.domain.useCases.genericos;

import com.geppa.BoletinsInformativos.domain.classes.Tag;
import com.geppa.BoletinsInformativos.domain.classes.conteudos.Conteudo;
import com.geppa.BoletinsInformativos.domain.exceptions.ValidacaoExcecao;
import com.geppa.BoletinsInformativos.domain.exceptions.ValidacaoTagNaoEncontradaExcecao;
import com.geppa.BoletinsInformativos.domain.useCases.validators.ValidadorGenerico;
import com.geppa.BoletinsInformativos.infrastructure.gateways.GatewayTagRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.util.List;

@Service
public class ValidarConteudo {

    private final ValidadorGenerico validadorGenerico;
    private final GatewayTagRepositorio gatewayTagRepositorio;

    public ValidarConteudo(ValidadorGenerico validadorGenerico, GatewayTagRepositorio gatewayTagRepositorio) {
        this.validadorGenerico = validadorGenerico;
        this.gatewayTagRepositorio = gatewayTagRepositorio;
    }

    public void executar(Conteudo objeto) {
        String nomeClasse = objeto.getClass().getSimpleName();
        Errors errors = new BeanPropertyBindingResult(objeto, nomeClasse);
        validadorGenerico.validar(objeto, errors);
        if (errors.hasErrors()) {
            throw new ValidacaoExcecao(errors);
        }

        verificarExistenciaTags(objeto.getTags());
    }

    private void verificarExistenciaTags(List<Tag> tags) {
        tags.forEach(tag -> {
            if (gatewayTagRepositorio.buscar(tag.getNome()).isEmpty()) {
                throw new ValidacaoTagNaoEncontradaExcecao(tag.getNome());
            }
        });
    }
}
