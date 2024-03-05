package com.geppa.BoletinsInformativos.application.controllers;

import com.geppa.BoletinsInformativos.application.dtos.padrao.RetornoPadraoDto;
import com.geppa.BoletinsInformativos.application.dtos.retorno.UltimoConteudoDto;
import com.geppa.BoletinsInformativos.domain.classes.conteudos.Conteudo;
import com.geppa.BoletinsInformativos.domain.useCases.ultimosConteudos.UltimosConteudosPorTipoConteudo;
import com.geppa.BoletinsInformativos.util.enums.messages.MensagensRetorno;
import com.geppa.BoletinsInformativos.util.mapper.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/conteudos")
public class ConteudoController {

    private final UltimosConteudosPorTipoConteudo ultimosConteudosPorTipoConteudo;

    public ConteudoController(UltimosConteudosPorTipoConteudo ultimosConteudosPorTipoConteudo) {
        this.ultimosConteudosPorTipoConteudo = ultimosConteudosPorTipoConteudo;
    }

    @GetMapping("/ultimos-por-conteudo")
    public ResponseEntity<RetornoPadraoDto> getUltimosConteudosPorConteudo(@RequestParam int quantidade) {

        HashMap<String, List<Conteudo>> ultimosConteudos = ultimosConteudosPorTipoConteudo.executar(quantidade);

        HashMap<String, List< UltimoConteudoDto>> ultimosConteudosDto = new HashMap<>();
        ultimosConteudos.forEach((k, v) -> {
          ultimosConteudosDto.put(k, Mapper.parseListObjects(v, UltimoConteudoDto.class));
        });

        RetornoPadraoDto retornoSucessoDto = new RetornoPadraoDto(
                MensagensRetorno.ULTIMOS_CONTEUDOS_ENCONTRADOS_COM_SUCESSO.getMensagem(),
                HttpStatus.OK.value(),
                ultimosConteudosDto
        );

        return ResponseEntity.ok(retornoSucessoDto);
    }
}
