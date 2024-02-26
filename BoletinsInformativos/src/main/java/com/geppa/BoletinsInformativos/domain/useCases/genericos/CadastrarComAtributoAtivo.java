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

import java.lang.reflect.Field;
import java.util.Optional;


@Service
public class CadastrarComAtributoAtivo {

    private final GatewayRepositoryGenericoFactory gatewayFactory;
    private final ValidadorGenerico validadorGenerico;
    private final AutoPreenchimentoAtributos autoPreenchimentoAtributos;


    public CadastrarComAtributoAtivo(GatewayRepositoryGenericoFactory gatewayFactory, ValidadorGenerico validadorGenerico, AutoPreenchimentoAtributos autoPreenchimentoAtributos) {
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

        Optional<T> objetoDuplicadoOptional = gatewayGenericoRepositorio.buscarDuplicado(objeto);
        if (objetoDuplicadoOptional.isPresent()) {
            T objetoDuplicado = objetoDuplicadoOptional.get();
            boolean ativo = isAtivo(objetoDuplicado);
            if (ativo) {
                throw new RegistroDuplicadoException();
            } else {
                reativarObjeto(objetoDuplicado);
                autoPreenchimentoAtributos.preAtualizacao(objetoDuplicado);
                return gatewayGenericoRepositorio.salvar(objetoDuplicado);
            }
        }
        autoPreenchimentoAtributos.preCadastro(objeto);
        return gatewayGenericoRepositorio.salvar(objeto);
    }

    private <T> boolean isAtivo(T objeto) {
        try {
            Field field = objeto.getClass().getDeclaredField("ativo");
            field.setAccessible(true);
            return (boolean) field.get(objeto);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            return false;
        }
    }

    private <T> void reativarObjeto(T objeto) {
        try {
            Field field = objeto.getClass().getDeclaredField("ativo");
            field.setAccessible(true);
            field.set(objeto, true);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Objeto não possui atributo ativo");
        }
    }
}