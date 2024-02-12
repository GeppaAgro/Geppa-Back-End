package com.geppa.BoletinsInformativos.application.controllers;

import com.geppa.BoletinsInformativos.application.dtos.padrao.RetornoPadraoComPaginacaoDto;
import com.geppa.BoletinsInformativos.application.dtos.retorno.BoletimInformativoCompletoDto;
import com.geppa.BoletinsInformativos.application.dtos.retorno.BoletimInformativoDto;
import com.geppa.BoletinsInformativos.application.dtos.padrao.RetornoPadraoDto;
import com.geppa.BoletinsInformativos.application.dtos.filters.FiltroGenericoDto;
import com.geppa.BoletinsInformativos.application.hateoas.HateoasPaginacao;
import com.geppa.BoletinsInformativos.domain.classes.BoletimInformativo;
import com.geppa.BoletinsInformativos.domain.useCases.boletimInformativo.ConsultaBoletimPorEdicao;
import com.geppa.BoletinsInformativos.domain.useCases.genericos.ConsultarTodos;
import com.geppa.BoletinsInformativos.util.mapper.Mapper;
import com.geppa.BoletinsInformativos.util.messages.MensagensRetorno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/boletins")
public class BoletimController {

    private final ConsultaBoletimPorEdicao consultaBoletimPorEdicao;
    private final ConsultarTodos consultarTodos;

    public BoletimController(ConsultaBoletimPorEdicao consultaBoletimPorEdicao, ConsultarTodos consultarTodos) {
        this.consultaBoletimPorEdicao = consultaBoletimPorEdicao;
        this.consultarTodos = consultarTodos;
    }

    @GetMapping("/{edicao}")
    public ResponseEntity<RetornoPadraoDto> buscarPorHash(@PathVariable String edicao) {
        BoletimInformativoCompletoDto boletimInformativoDto = Mapper.parseObject(consultaBoletimPorEdicao.executar(edicao), BoletimInformativoCompletoDto.class);
//      TODO: adicionar hateoas

        RetornoPadraoDto retornoSucessoDto = new RetornoPadraoDto(
                MensagensRetorno.CONTEUDO_ENCONTRADO_COM_SUCESSO.getMensagem(),
                HttpStatus.OK.value(),
                boletimInformativoDto
        );
        return ResponseEntity.ok(retornoSucessoDto);
    }

    @GetMapping
    public ResponseEntity<RetornoPadraoComPaginacaoDto> buscarTodos(@PageableDefault(sort = "dataCadastro", direction = Sort.Direction.DESC) Pageable pageable,
                                                                    @ModelAttribute FiltroGenericoDto filtro) {
        Page<BoletimInformativo> boletimInformativos = consultarTodos.executar(pageable, filtro, BoletimInformativo.class);
        Page<BoletimInformativoDto> boletimInformativoDtos = boletimInformativos.map(video -> Mapper.parseObject(video, BoletimInformativoDto.class));

//      TODO: refatorar a adição de hateoas ao boletim
        boletimInformativoDtos.forEach(bl -> bl.add(linkTo(methodOn(BoletimController.class).buscarPorHash(bl.getEdicao())).withSelfRel()));

        RetornoPadraoComPaginacaoDto retornoSucessoDto = new RetornoPadraoComPaginacaoDto(
                MensagensRetorno.BUSCA_REALIZADA_COM_SUCESSO.getMensagem(),
                HttpStatus.OK.value(),
                boletimInformativoDtos.getContent(),
                boletimInformativoDtos.getPageable().getPageNumber(),
                boletimInformativoDtos.getSize(),
                boletimInformativoDtos.getTotalElements(),
                boletimInformativoDtos.getTotalPages(),
                pageable.getSort().toString()
        );

        HateoasPaginacao.addHateoas(retornoSucessoDto, boletimInformativoDtos);

        return ResponseEntity.ok(retornoSucessoDto);
    }

}
