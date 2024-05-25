package com.geppa.BoletinsInformativos.domain.useCases.genericos;

import com.geppa.BoletinsInformativos.domain.classes.conteudos.Conteudo;
import com.geppa.BoletinsInformativos.domain.exceptions.RegistroDuplicadoException;
import com.geppa.BoletinsInformativos.domain.exceptions.RegistroNaoEncontradoException;
import com.geppa.BoletinsInformativos.domain.exceptions.ValidacaoExcecao;
import com.geppa.BoletinsInformativos.domain.useCases.validators.ValidadorGenerico;
import com.geppa.BoletinsInformativos.infrastructure.gateways.GatewayGenericoRepositorio;
import com.geppa.BoletinsInformativos.infrastructure.gateways.GatewayRepositoryGenericoFactory;
import com.geppa.BoletinsInformativos.util.ConverteStringUUID;
import com.geppa.BoletinsInformativos.util.autoPreenchimentoAtributos.AutoPreenchimentoAtributos;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.util.Optional;
import java.util.UUID;

@Service
public class AtualizarConteudo {

    private final ValidadorGenerico validadorGenerico;
    private final GatewayRepositoryGenericoFactory gatewayFactory;
    private final AutoPreenchimentoAtributos autoPreenchimentoAtributos;

    public AtualizarConteudo(ValidadorGenerico validadorGenerico, GatewayRepositoryGenericoFactory gatewayFactory, AutoPreenchimentoAtributos autoPreenchimentoAtributos) {
        this.validadorGenerico = validadorGenerico;
        this.gatewayFactory = gatewayFactory;
        this.autoPreenchimentoAtributos = autoPreenchimentoAtributos;
    }


    public <T extends Conteudo> T executar(T conteudo, Class<T> clazz, String id) throws ValidacaoExcecao, RegistroNaoEncontradoException, RegistroDuplicadoException {
        UUID uuid = ConverteStringUUID.converter(id);
        GatewayGenericoRepositorio<T> gatewayGenericoRepositorio = gatewayFactory.getGatewayFor(clazz);

        validarConstrains(conteudo, clazz);

        Optional<T> conteudoOptional = gatewayGenericoRepositorio.buscarPorId(uuid);
        if (conteudoOptional.isEmpty()) {
            throw new RegistroNaoEncontradoException();
        }

        T conteudoExistente = conteudoOptional.get();
        conteudo.setId(conteudoExistente.getId());
        conteudo.setDataCadastro(conteudoExistente.getDataCadastro());
        conteudo.setBoletimInformativo(conteudoExistente.getBoletimInformativo());

        autoPreenchimentoAtributos.preAtualizacao(conteudo);
        return gatewayGenericoRepositorio.salvar(conteudo);
    }

    private <T extends Conteudo> void validarConstrains(T conteudo, Class<T> clazz) throws ValidacaoExcecao {
        Errors errors = new BeanPropertyBindingResult(conteudo, clazz.getSimpleName());
        validadorGenerico.validar(conteudo, errors);
        if (errors.hasErrors()) {
            throw new ValidacaoExcecao(errors);
        }
    }
}
