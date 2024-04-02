package com.geppa.BoletinsInformativos.application.controllers;

import com.geppa.BoletinsInformativos.application.dtos.padrao.RetornoPadraoComPaginacaoDto;
import com.geppa.BoletinsInformativos.application.dtos.padrao.RetornoPadraoDto;
import com.geppa.BoletinsInformativos.application.dtos.retorno.TagDto;
import com.geppa.BoletinsInformativos.application.hateoas.HateoasPaginacao;
import com.geppa.BoletinsInformativos.domain.classes.Tag;
import com.geppa.BoletinsInformativos.domain.useCases.genericos.ConsultarTodos;
import com.geppa.BoletinsInformativos.domain.useCases.tags.BuscarTagPorNome;
import com.geppa.BoletinsInformativos.util.enums.messages.MensagensRetorno;
import com.geppa.BoletinsInformativos.util.mapper.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagsController {

    private final BuscarTagPorNome buscarPorNome;
    private final ConsultarTodos consultarTodos;

    public TagsController(BuscarTagPorNome buscarPorNome, ConsultarTodos consultarTodos) {
        this.buscarPorNome = buscarPorNome;
        this.consultarTodos = consultarTodos;
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

    @GetMapping
    public ResponseEntity<RetornoPadraoComPaginacaoDto> buscarTodos(
            @PageableDefault(sort = "nome", direction = Sort.Direction.DESC) Pageable pageable) {

        Page<Tag> tags = consultarTodos.executar(pageable, Tag.class);

        RetornoPadraoComPaginacaoDto retornoSucessoDto = new RetornoPadraoComPaginacaoDto(
                MensagensRetorno.BUSCA_REALIZADA_COM_SUCESSO.getMensagem(),
                HttpStatus.OK.value(),
                Mapper.parseListObjects(tags.getContent(), TagDto.class),
                tags.getPageable().getPageNumber(),
                tags.getSize(),
                tags.getTotalElements(),
                tags.getTotalPages(),
                pageable.getSort().toString()
        );

        HateoasPaginacao.addHateoas(retornoSucessoDto, tags);

        return ResponseEntity.ok(retornoSucessoDto);
    }

}
