package com.geppa.BoletinsInformativos.application.controllers.conteudos;

import com.geppa.BoletinsInformativos.application.dtos.padrao.RetornoPadraoComPaginacaoDto;
import com.geppa.BoletinsInformativos.application.dtos.padrao.RetornoPadraoDto;
import com.geppa.BoletinsInformativos.application.dtos.retorno.conteudos.ArtigoDto;
import com.geppa.BoletinsInformativos.application.dtos.filters.FiltroGenericoDto;

import com.geppa.BoletinsInformativos.application.hateoas.HateoasPaginacao;
import com.geppa.BoletinsInformativos.domain.classes.conteudos.Artigo;
import com.geppa.BoletinsInformativos.domain.useCases.genericos.ConsultaPorHash;
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

@RestController
@RequestMapping("/artigos")
public class ArtigoController {

    private final ConsultaPorHash consultaPorHash;
    private final ConsultarTodos consultarTodos;

    public ArtigoController(ConsultaPorHash consultaPorHash, ConsultarTodos consultarTodos) {
        this.consultaPorHash = consultaPorHash;
        this.consultarTodos = consultarTodos;
    }

    @GetMapping("/{hash}")
    public ResponseEntity<RetornoPadraoDto> buscarPorHash(@PathVariable String hash) {
        ArtigoDto artigoDto = Mapper.parseObject(consultaPorHash.executar(hash, Artigo.class), ArtigoDto.class);
//      TODO: adicionar hateoas

        RetornoPadraoDto retornoSucessoDto = new RetornoPadraoDto(
                MensagensRetorno.CONTEUDO_ENCONTRADO_COM_SUCESSO.getMensagem(),
                HttpStatus.OK.value(),
                artigoDto
        );
        return ResponseEntity.ok(retornoSucessoDto);
    }

    @GetMapping
    public ResponseEntity<RetornoPadraoComPaginacaoDto> buscarTodos(
            @PageableDefault(sort = "dataCadastro", direction = Sort.Direction.DESC) Pageable pageable,
            @ModelAttribute FiltroGenericoDto filtro) {

        Page<Artigo> artigos = consultarTodos.executar(pageable, filtro, Artigo.class);
        Page<ArtigoDto> artigoDtos = artigos.map(artigo -> Mapper.parseObject(artigo, ArtigoDto.class));

//        TODO: adicionar hateoas aos conteudos

        RetornoPadraoComPaginacaoDto retornoSucessoDto = new RetornoPadraoComPaginacaoDto(
                MensagensRetorno.BUSCA_REALIZADA_COM_SUCESSO.getMensagem(),
                HttpStatus.OK.value(),
                artigoDtos.getContent(),
                artigoDtos.getPageable().getPageNumber(),
                artigoDtos.getSize(),
                artigoDtos.getTotalElements(),
                artigoDtos.getTotalPages(),
                pageable.getSort().toString()
        );

        HateoasPaginacao.addHateoas(retornoSucessoDto, artigos);

        return ResponseEntity.ok(retornoSucessoDto);
    }
}
