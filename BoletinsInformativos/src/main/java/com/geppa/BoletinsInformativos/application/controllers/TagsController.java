package com.geppa.BoletinsInformativos.application.controllers;

import com.geppa.BoletinsInformativos.application.dtos.cadastro.TagCadastroDto;
import com.geppa.BoletinsInformativos.application.dtos.padrao.RetornoPadraoComPaginacaoDto;
import com.geppa.BoletinsInformativos.application.dtos.padrao.RetornoPadraoDto;
import com.geppa.BoletinsInformativos.application.dtos.retorno.TagDto;
import com.geppa.BoletinsInformativos.application.hateoas.HateoasPaginacao;
import com.geppa.BoletinsInformativos.domain.classes.Tag;
import com.geppa.BoletinsInformativos.domain.useCases.genericos.Cadastrar;
import com.geppa.BoletinsInformativos.domain.useCases.genericos.ConsultarTodos;
import com.geppa.BoletinsInformativos.domain.useCases.tags.AtualizarTag;
import com.geppa.BoletinsInformativos.domain.useCases.tags.BuscarTagPorNome;
import com.geppa.BoletinsInformativos.domain.useCases.tags.DeletarTag;
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
    private final DeletarTag deletarTag;
    private final Cadastrar cadastrar;
    private final AtualizarTag atualizar;

    public TagsController(BuscarTagPorNome buscarPorNome, ConsultarTodos consultarTodos,
                          Cadastrar cadastrar, DeletarTag deletarTag, AtualizarTag atualizar) {
        this.buscarPorNome = buscarPorNome;
        this.consultarTodos = consultarTodos;
        this.cadastrar = cadastrar;
        this.deletarTag = deletarTag;
        this.atualizar = atualizar;
    }

    @GetMapping("/{nome}")
    public ResponseEntity<RetornoPadraoDto> buscarPorNome(@PathVariable String nome) {
        List<Tag> tags = buscarPorNome.executar(nome);

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

    @DeleteMapping("/{nome}")
    public ResponseEntity<RetornoPadraoDto> deletar(@PathVariable String nome) {
        deletarTag.executar(nome);

        return ResponseEntity.ok(new RetornoPadraoDto(
                MensagensRetorno.TAG_DELETADA_COM_SUCESSO.getMensagem(),
                HttpStatus.OK.value()
        ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RetornoPadraoDto> atualizar(@RequestBody TagCadastroDto tagDto, @PathVariable String id) {
        Tag tagAtualizada = atualizar.executar(Mapper.parseObject(tagDto, Tag.class), id);

        return ResponseEntity.ok(new RetornoPadraoDto(
                MensagensRetorno.TAG_ATUALIZADA_COM_SUCESSO.getMensagem(),
                HttpStatus.OK.value(),
                Mapper.parseObject(tagAtualizada, TagDto.class)
        ));
    }

}
