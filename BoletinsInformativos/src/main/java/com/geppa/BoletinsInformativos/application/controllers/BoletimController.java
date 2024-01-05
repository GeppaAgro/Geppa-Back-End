package com.geppa.BoletinsInformativos.application.controllers;

import com.geppa.BoletinsInformativos.application.dtos.retorno.BoletimInformativoDto;
import com.geppa.BoletinsInformativos.application.dtos.retorno.RetornoPadraoDto;
import com.geppa.BoletinsInformativos.domain.useCases.boletimInformativo.ConsultaBoletimPorEdicao;
import com.geppa.BoletinsInformativos.util.mapper.Mapper;
import com.geppa.BoletinsInformativos.util.messages.MensagensRetorno;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boletins")
public class BoletimController {

    private final ConsultaBoletimPorEdicao consultaBoletimPorEdicao;

    public BoletimController(ConsultaBoletimPorEdicao consultaBoletimPorEdicao) {
        this.consultaBoletimPorEdicao = consultaBoletimPorEdicao;
    }

    @GetMapping("/{edicao}")
    public ResponseEntity<RetornoPadraoDto> buscarPorHash(@PathVariable String edicao) {
        BoletimInformativoDto boletimInformativoDto = Mapper.parseObject(consultaBoletimPorEdicao.executar(edicao), BoletimInformativoDto.class);
//      TODO: adicionar hateoas

        RetornoPadraoDto retornoSucessoDto = new RetornoPadraoDto(
                MensagensRetorno.CONTEUDO_ENCONTRADO_COM_SUCESSO.getMensagem(),
                HttpStatus.OK.value(),
                boletimInformativoDto
        );
        return ResponseEntity.ok(retornoSucessoDto);
    }

}
