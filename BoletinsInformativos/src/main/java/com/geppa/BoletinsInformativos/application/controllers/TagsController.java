package com.geppa.BoletinsInformativos.application.controllers;

import com.geppa.BoletinsInformativos.application.dtos.cadastro.InscricaoNewsletterCadastroDto;
import com.geppa.BoletinsInformativos.application.dtos.cadastro.TagCadastroDto;
import com.geppa.BoletinsInformativos.application.dtos.padrao.RetornoPadraoComPaginacaoDto;
import com.geppa.BoletinsInformativos.application.dtos.padrao.RetornoPadraoDto;
import com.geppa.BoletinsInformativos.application.dtos.retorno.InscricaoNewsletterDto;
import com.geppa.BoletinsInformativos.application.dtos.retorno.TagDto;
import com.geppa.BoletinsInformativos.application.hateoas.HateoasPaginacao;
import com.geppa.BoletinsInformativos.domain.classes.InscricaoNewsletter;
import com.geppa.BoletinsInformativos.domain.classes.Tag;
import com.geppa.BoletinsInformativos.domain.useCases.genericos.Cadastrar;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagsController {

    private final BuscarTagPorNome buscarPorNome;
    private final ConsultarTodos consultarTodos;
    private final Cadastrar cadastrar;

    public TagsController(BuscarTagPorNome buscarPorNome, ConsultarTodos consultarTodos, Cadastrar cadastrar) {
        this.buscarPorNome = buscarPorNome;
        this.consultarTodos = consultarTodos;
        this.cadastrar = cadastrar;
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

    @PostMapping
    public ResponseEntity<RetornoPadraoDto> cadastrarTag(@RequestBody TagCadastroDto tagCadastroDto) {
        Tag tag = cadastrar.executar(Mapper.parseObject(tagCadastroDto, Tag.class), Tag.class);

        RetornoPadraoDto resposta = new RetornoPadraoDto(MensagensRetorno.TAG_CADASTRADA_SUCESSO.getMensagem(), 201,
                Mapper.parseObject(tag, TagDto.class));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tag.getId()).toUri();
        return ResponseEntity.created(location).body(resposta);
    }

}
