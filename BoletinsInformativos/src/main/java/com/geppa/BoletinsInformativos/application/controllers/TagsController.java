package com.geppa.BoletinsInformativos.application.controllers;

import com.geppa.BoletinsInformativos.application.dtos.padrao.RetornoPadraoDto;
import com.geppa.BoletinsInformativos.application.dtos.retorno.TagDto;
import com.geppa.BoletinsInformativos.domain.classes.Tag;
import com.geppa.BoletinsInformativos.domain.useCases.tags.BuscarTagPorNome;
import com.geppa.BoletinsInformativos.util.enums.messages.MensagensRetorno;
import com.geppa.BoletinsInformativos.util.mapper.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagsController {

    private final BuscarTagPorNome buscarPorNome;

    public TagsController(BuscarTagPorNome buscarPorNome) {
        this.buscarPorNome = buscarPorNome;
    }

    @GetMapping("/buscarPorNome")
    public ResponseEntity<RetornoPadraoDto> buscarPorNome(@RequestParam String nomeTag) {
        List<Tag> tags = buscarPorNome.executar(nomeTag);

        return ResponseEntity.ok(new RetornoPadraoDto(
                MensagensRetorno.BUSCA_REALIZADA_COM_SUCESSO.getMensagem(),
                HttpStatus.OK.value(),
                Mapper.parseListObjects(tags, TagDto.class)
        ));
    }

}
