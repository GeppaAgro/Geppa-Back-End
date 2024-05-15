package com.geppa.BoletinsInformativos.application.controllers;

import com.geppa.BoletinsInformativos.application.dtos.cadastro.IndicadorCadastroDto;
import com.geppa.BoletinsInformativos.application.dtos.padrao.RetornoPadraoDto;
import com.geppa.BoletinsInformativos.domain.classes.Indicador;
import com.geppa.BoletinsInformativos.domain.useCases.genericos.ValidarObjeto;
import com.geppa.BoletinsInformativos.util.enums.messages.MensagensRetorno;
import com.geppa.BoletinsInformativos.util.mapper.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/indicadores")
public class IndicadorController {

    private final ValidarObjeto<Indicador> validarIndicador;

    public IndicadorController(ValidarObjeto<Indicador> validarIndicador) {
        this.validarIndicador = validarIndicador;
    }

    @PostMapping("/validar")
    public ResponseEntity<RetornoPadraoDto> validarIndicador(@RequestBody IndicadorCadastroDto indicadorCadastroDto) {
        Indicador indicador = Mapper.parseObject(indicadorCadastroDto, Indicador.class);
        validarIndicador.executar(indicador);
        return ResponseEntity.ok(new RetornoPadraoDto(MensagensRetorno.INDICADOR_VALIDADO_COM_SUCESSO.getMensagem(), HttpStatus.OK.value()));
    }
}
