package com.geppa.BoletinsInformativos.domain.useCases.Indicador;

import com.geppa.BoletinsInformativos.domain.classes.Indicador;
import com.geppa.BoletinsInformativos.domain.exceptions.RegistroNaoEncontradoException;
import com.geppa.BoletinsInformativos.domain.exceptions.ValidacaoExcecao;
import com.geppa.BoletinsInformativos.domain.useCases.validators.ValidadorGenerico;
import com.geppa.BoletinsInformativos.infrastructure.gateways.GatewayIndicador;
import com.geppa.BoletinsInformativos.util.ConverteStringUUID;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
public class AtualizarIndicador {
    private final GatewayIndicador gatewayIndicador;
    private final ValidadorGenerico validadorGenerico;

    public AtualizarIndicador(GatewayIndicador gatewayIndicador, ValidadorGenerico validadorGenerico) {
        this.gatewayIndicador = gatewayIndicador;
        this.validadorGenerico = validadorGenerico;
    }


    public Indicador executar(String idStr, Indicador indicador) {
        UUID id = ConverteStringUUID.converter(idStr);
        Errors errors = new BeanPropertyBindingResult(indicador, indicador.getClass().getSimpleName());
        validadorGenerico.validar(indicador, errors);
        if (errors.hasErrors()) {
            throw new ValidacaoExcecao(errors);
        }

        Optional<Indicador> indicadorOptional = gatewayIndicador.buscarPorId(id);

        if (indicadorOptional.isEmpty()) {
            throw new RegistroNaoEncontradoException();
        }

        Indicador indicadorExistente = indicadorOptional.get();
        indicador.setId(indicadorExistente.getId());
        indicador.setData(LocalDate.now());
        indicador.setBoletimInformativo(indicadorExistente.getBoletimInformativo());

        return gatewayIndicador.salvar(indicador);
    }
}
