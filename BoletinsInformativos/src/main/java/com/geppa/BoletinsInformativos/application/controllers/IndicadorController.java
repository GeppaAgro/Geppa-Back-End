package com.geppa.BoletinsInformativos.application.controllers;

import com.geppa.BoletinsInformativos.application.dtos.cadastro.IndicadorCadastroDto;
import com.geppa.BoletinsInformativos.application.dtos.padrao.RetornoPadraoDto;
import com.geppa.BoletinsInformativos.application.dtos.retorno.IndicadorDto;
import com.geppa.BoletinsInformativos.domain.classes.Indicador;
import com.geppa.BoletinsInformativos.domain.useCases.Indicador.AtualizarIndicador;
import com.geppa.BoletinsInformativos.domain.useCases.Indicador.DeletarIndicador;
import com.geppa.BoletinsInformativos.domain.useCases.genericos.ValidarObjeto;
import com.geppa.BoletinsInformativos.util.enums.messages.MensagensRetorno;
import com.geppa.BoletinsInformativos.util.mapper.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/indicadores")
public class IndicadorController {

    private final ValidarObjeto<Indicador> validarIndicador;
    private final AtualizarIndicador atualizarIndicador;
    private final DeletarIndicador deletarIndicador;

    public IndicadorController(ValidarObjeto<Indicador> validarIndicador, AtualizarIndicador atualizarIndicador, DeletarIndicador deletarIndicador) {
        this.validarIndicador = validarIndicador;
        this.atualizarIndicador = atualizarIndicador;
        this.deletarIndicador = deletarIndicador;
    }

    @PostMapping("/validar")
    public ResponseEntity<RetornoPadraoDto> validarIndicador(@RequestBody IndicadorCadastroDto indicadorCadastroDto) {
        Indicador indicador = Mapper.parseObject(indicadorCadastroDto, Indicador.class);
        validarIndicador.executar(indicador);
        return ResponseEntity.ok(new RetornoPadraoDto(MensagensRetorno.INDICADOR_VALIDADO_COM_SUCESSO.getMensagem(), HttpStatus.OK.value()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RetornoPadraoDto> atualizarIndicador(@PathVariable String id,
                                                               @RequestBody IndicadorCadastroDto indicadorCadastroDto) {
        Indicador indicador = Mapper.parseObject(indicadorCadastroDto, Indicador.class);
        Indicador indicadorAtualizado = atualizarIndicador.executar(id, indicador);
        IndicadorDto indicadorDto = Mapper.parseObject(indicadorAtualizado, IndicadorDto.class);
        return ResponseEntity.ok(new RetornoPadraoDto(MensagensRetorno.INDICADOR_ATUALIZADO_COM_SUCESSO.getMensagem(),
                HttpStatus.OK.value(), indicadorDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RetornoPadraoDto> deletarIndicador(@PathVariable String id) {
        deletarIndicador.executar(id);
        return ResponseEntity.ok(new RetornoPadraoDto(MensagensRetorno.INDICADOR_DELETADO_COM_SUCESSO.getMensagem(),
                HttpStatus.OK.value()));
    }
}
