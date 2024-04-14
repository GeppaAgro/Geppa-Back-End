package com.geppa.BoletinsInformativos.application.controllers;

import com.geppa.BoletinsInformativos.application.dtos.padrao.RetornoPadraoDto;
import com.geppa.BoletinsInformativos.application.dtos.retorno.UltimoConteudoDto;
import com.geppa.BoletinsInformativos.application.dtos.retorno.conteudos.ConteudoDto;
import com.geppa.BoletinsInformativos.domain.classes.conteudos.Conteudo;
import com.geppa.BoletinsInformativos.domain.useCases.ultimosConteudos.UltimosConteudos;
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
    private final UltimosConteudos ultimosConteudos;

    public ConteudoController(UltimosConteudosPorTipoConteudo ultimosConteudosPorTipoConteudo, UltimosConteudos ultimosConteudos) {
        this.ultimosConteudosPorTipoConteudo = ultimosConteudosPorTipoConteudo;
        this.ultimosConteudos = ultimosConteudos;
    }


    @GetMapping
    public ResponseEntity<RetornoPadraoDto> getUltimosConteudos(@RequestParam int size) {

        List<Conteudo> conteudos = ultimosConteudos.executar(size);
        List<ConteudoDto> conteudosDto = Mapper.parseListObjects(conteudos, ConteudoDto.class);

        RetornoPadraoDto retornoSucessoDto = new RetornoPadraoDto(
                MensagensRetorno.ULTIMOS_CONTEUDOS_ENCONTRADOS_COM_SUCESSO.getMensagem(),
                HttpStatus.OK.value(), conteudosDto
        );

        return ResponseEntity.ok(retornoSucessoDto);
    }

    @GetMapping("/ultimos-por-conteudo")
    public ResponseEntity<RetornoPadraoDto> getUltimosConteudosPorConteudo(@RequestParam int size) {

        HashMap<String, List<Conteudo>> ultimosConteudos = ultimosConteudosPorTipoConteudo.executar(size);

        HashMap<String, List<UltimoConteudoDto>> ultimosConteudosDto = new HashMap<>();
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
