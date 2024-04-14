package com.geppa.BoletinsInformativos.domain.useCases.tags;

import com.geppa.BoletinsInformativos.domain.classes.Tag;
import com.geppa.BoletinsInformativos.domain.exceptions.HashInvalidaExcecao;
import com.geppa.BoletinsInformativos.domain.exceptions.RegistroDuplicadoException;
import com.geppa.BoletinsInformativos.domain.exceptions.RegistroNaoEncontradoException;
import com.geppa.BoletinsInformativos.domain.exceptions.ValidacaoExcecao;
import com.geppa.BoletinsInformativos.domain.useCases.validators.ValidadorGenerico;
import com.geppa.BoletinsInformativos.infrastructure.gateways.GatewayTagRepositorio;
import com.geppa.BoletinsInformativos.util.ConverteStringUUID;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.util.UUID;

@Service
public class AtualizarTag {

    private final ValidadorGenerico validadorGenerico;
    private final GatewayTagRepositorio gatewayTagRepositorio;

    public AtualizarTag(ValidadorGenerico validadorGenerico, GatewayTagRepositorio gatewayTagRepositorio) {
        this.validadorGenerico = validadorGenerico;
        this.gatewayTagRepositorio = gatewayTagRepositorio;
    }


    public Tag executar(Tag tag, String id) {

        UUID uuid = ConverteStringUUID.converter(id);

        Errors errors = new BeanPropertyBindingResult(tag, Tag.class.getSimpleName());
        validadorGenerico.validar(tag, errors);
        if (errors.hasErrors()) {
            throw new ValidacaoExcecao(errors);
        }

        Tag tagExistente = gatewayTagRepositorio.buscarPorId(uuid)
                .orElseThrow(RegistroNaoEncontradoException::new);

        tag.setId(tagExistente.getId());

        if (gatewayTagRepositorio.buscarDuplicado(tag).isPresent()) {
            throw new RegistroDuplicadoException();
        }

        return gatewayTagRepositorio.salvar(tag);
    }

}
