package com.geppa.BoletinsInformativos.domain.useCases.boletimInformativo;

import com.geppa.BoletinsInformativos.domain.classes.BoletimInformativo;
import com.geppa.BoletinsInformativos.domain.exceptions.ValidacaoExcecao;
import com.geppa.BoletinsInformativos.domain.useCases.validators.ValidadorGenerico;
import com.geppa.BoletinsInformativos.infrastructure.gateways.GatewayBoletimRepositorio;
import com.geppa.BoletinsInformativos.infrastructure.gateways.GatewayTagRepositorio;
import com.geppa.BoletinsInformativos.util.GeradorNumeroEdicao;
import com.geppa.BoletinsInformativos.util.autoPreenchimentoAtributos.AutoPreenchimentoAtributos;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.time.LocalDate;

@Service
public class CadastroBoletimInformativo {

    private final ValidadorGenerico validadorGenerico;
    private final GatewayBoletimRepositorio gatewayBoletimRepositorio;
    private final AutoPreenchimentoAtributos autoPreenchimentoAtributos;

    public CadastroBoletimInformativo(ValidadorGenerico validadorGenerico,
                                      GatewayBoletimRepositorio gatewayBoletimRepositorio,
                                      AutoPreenchimentoAtributos autoPreenchimentoAtributos) {
        this.validadorGenerico = validadorGenerico;
        this.gatewayBoletimRepositorio = gatewayBoletimRepositorio;
        this.autoPreenchimentoAtributos = autoPreenchimentoAtributos;
    }

    public BoletimInformativo executar(BoletimInformativo boletimInformativo) {
        Errors errors = new BeanPropertyBindingResult(boletimInformativo, BoletimInformativo.class.getSimpleName());
        validadorGenerico.validar(boletimInformativo, errors);
        if (errors.hasErrors()) {
            throw new ValidacaoExcecao(errors);
        }

        boletimInformativo.setEdicao(GeradorNumeroEdicao.gerarNumeroEdicao());
        boletimInformativo.setDataPublicacao(LocalDate.now());

        autoPreenchimentoAtributos.preCadastro(boletimInformativo);

        return gatewayBoletimRepositorio.salvar(boletimInformativo);
    }

}
