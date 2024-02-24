package com.geppa.BoletinsInformativos.domain.useCases.genericos;

import com.geppa.BoletinsInformativos.domain.exceptions.RegistroDuplicadoException;
import com.geppa.BoletinsInformativos.domain.exceptions.ValidacaoExcecao;
import com.geppa.BoletinsInformativos.domain.useCases.validators.ValidadorGenerico;
import com.geppa.BoletinsInformativos.infrastructure.gateways.GatewayGenericoRepositorio;
import com.geppa.BoletinsInformativos.infrastructure.gateways.GatewayRepositoryGenericoFactory;
import com.geppa.BoletinsInformativos.util.autoPreenchimentoAtributos.AutoPreenchimentoAtributos;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;


@Service
public class Cadastrar {

    private final GatewayRepositoryGenericoFactory gatewayFactory;
    private final ValidadorGenerico validadorGenerico;
    private final AutoPreenchimentoAtributos autoPreenchimentoAtributos;


    public Cadastrar(GatewayRepositoryGenericoFactory gatewayFactory, ValidadorGenerico validadorGenerico, AutoPreenchimentoAtributos autoPreenchimentoAtributos) {
        this.gatewayFactory = gatewayFactory;
        this.validadorGenerico = validadorGenerico;
        this.autoPreenchimentoAtributos = autoPreenchimentoAtributos;
    }

    public <T> T executar(T objeto, Class<T> clazz) {
        Errors errors = new BeanPropertyBindingResult(objeto, clazz.getSimpleName());
        validadorGenerico.validar(objeto, errors);
        if (errors.hasErrors()) {
            throw new ValidacaoExcecao(errors);
        }

        GatewayGenericoRepositorio<T> gatewayGenericoRepositorio = gatewayFactory.getGatewayFor(clazz);

        if (gatewayGenericoRepositorio.buscarDuplicado(objeto).isPresent()) {
            throw new RegistroDuplicadoException();
        }

        autoPreenchimentoAtributos.preCadastro(objeto);
        return gatewayGenericoRepositorio.salvar(objeto);
    }
}
