package com.geppa.BoletinsInformativos.application.controllers.conteudos;

import com.geppa.BoletinsInformativos.application.dtos.cadastro.conteudos.NoticiaCadastroDto;
import com.geppa.BoletinsInformativos.application.dtos.padrao.RetornoPadraoComPaginacaoDto;
import com.geppa.BoletinsInformativos.application.dtos.padrao.RetornoPadraoDto;
import com.geppa.BoletinsInformativos.application.dtos.retorno.conteudos.NoticiaDto;
import com.geppa.BoletinsInformativos.application.dtos.filters.FiltroGenericoDto;
import com.geppa.BoletinsInformativos.application.hateoas.HateoasPaginacao;
import com.geppa.BoletinsInformativos.domain.classes.conteudos.Noticia;
import com.geppa.BoletinsInformativos.domain.useCases.genericos.*;
import com.geppa.BoletinsInformativos.util.mapper.Mapper;
import com.geppa.BoletinsInformativos.util.enums.messages.MensagensRetorno;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/noticias")
public class NoticiaController {

    private final ConsultaPorHash consultaPorHash;
    private final ConsultarTodos consultarTodos;
    private final ValidarConteudo validarConteudo;
    private final AtualizarConteudo atualizarConteudo;
    private final DeletarConteudo deletarConteudo;

    public NoticiaController(ConsultaPorHash consultaPorHash, ConsultarTodos consultarTodos,
                             ValidarConteudo validarConteudo, AtualizarConteudo atualizarConteudo, DeletarConteudo deletarConteudo) {
        this.consultaPorHash = consultaPorHash;
        this.consultarTodos = consultarTodos;
        this.validarConteudo = validarConteudo;
        this.atualizarConteudo = atualizarConteudo;
        this.deletarConteudo = deletarConteudo;
    }

    @GetMapping("/{hash}")
    public ResponseEntity<RetornoPadraoDto> buscarPorHash(@PathVariable String hash) {
        Noticia noticia = consultaPorHash.executar(hash, Noticia.class);
        NoticiaDto noticiaDto = Mapper.parseObject(noticia, NoticiaDto.class);
//      TODO: adicionar hateoas

        RetornoPadraoDto retornoSucessoDto = new RetornoPadraoDto(
                MensagensRetorno.CONTEUDO_ENCONTRADO_COM_SUCESSO.getMensagem(),
                HttpStatus.OK.value(),
                noticiaDto
        );
        return ResponseEntity.ok(retornoSucessoDto);
    }

    @GetMapping
    public ResponseEntity<RetornoPadraoComPaginacaoDto> buscarTodos(@PageableDefault(sort = "dataCadastro", direction = Sort.Direction.DESC) Pageable pageable,
                                                                    @ModelAttribute FiltroGenericoDto filtro) {
        Page<Noticia> noticias = consultarTodos.executar(pageable, filtro, Noticia.class);
        Page<NoticiaDto> noticiasDtos = noticias.map(noticia -> Mapper.parseObject(noticia, NoticiaDto.class));

//        TODO: adicionar hateoas aos conteudos

        RetornoPadraoComPaginacaoDto retornoSucessoDto = new RetornoPadraoComPaginacaoDto(
                MensagensRetorno.BUSCA_REALIZADA_COM_SUCESSO.getMensagem(),
                HttpStatus.OK.value(),
                noticiasDtos.getContent(),
                noticiasDtos.getPageable().getPageNumber(),
                noticiasDtos.getSize(),
                noticiasDtos.getTotalElements(),
                noticiasDtos.getTotalPages(),
                pageable.getSort().toString()
        );

        HateoasPaginacao.addHateoas(retornoSucessoDto, noticias);

        return ResponseEntity.ok(retornoSucessoDto);
    }

    @PostMapping("/validar")
    public ResponseEntity<RetornoPadraoDto> validarNoticia(@RequestBody NoticiaCadastroDto noticiaDto) {
        Noticia noticia = Mapper.parseObject(noticiaDto, Noticia.class);
        validarConteudo.executar(noticia);
        return ResponseEntity.ok(new RetornoPadraoDto(MensagensRetorno.CONTEUDO_VALIDADO_COM_SUCESSO.getMensagem(), HttpStatus.OK.value()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RetornoPadraoDto> atualizar(@RequestBody NoticiaCadastroDto noticiaCadastroDto, @PathVariable String id) {
        Noticia noticiaAtualizada = atualizarConteudo.executar(Mapper.parseObject(noticiaCadastroDto, Noticia.class), Noticia.class, id);

        return ResponseEntity.ok(new RetornoPadraoDto(
                MensagensRetorno.CONTEUDO_ATUALIZADO_COM_SUCESSO.getMensagem(),
                HttpStatus.OK.value(),
                Mapper.parseObject(noticiaAtualizada, NoticiaDto.class)
        ));
    }

    @DeleteMapping("/{hash}")
    public ResponseEntity<RetornoPadraoDto> deletar(@PathVariable String hash) {
        deletarConteudo.executar(hash, Noticia.class);
        return ResponseEntity.ok(new RetornoPadraoDto(MensagensRetorno.CONTEUDO_DELETADO_COM_SUCESSO.getMensagem(), HttpStatus.OK.value()));
    }

}
