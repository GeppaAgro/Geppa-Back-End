package com.geppa.BoletinsInformativos.application.controllers.conteudos;

import com.geppa.BoletinsInformativos.application.dtos.padrao.RetornoPadraoComPaginacaoDto;
import com.geppa.BoletinsInformativos.application.dtos.padrao.RetornoPadraoDto;
import com.geppa.BoletinsInformativos.application.dtos.retorno.conteudos.CursoDto;
import com.geppa.BoletinsInformativos.application.hateoas.HateoasPaginacao;
import com.geppa.BoletinsInformativos.domain.classes.conteudos.Curso;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final ConsultaPorHash consultaPorHash;
    private final ConsultarTodos consultarTodos;

    public CursoController(ConsultaPorHash consultaPorHash, ConsultarTodos consultarTodos) {
        this.consultaPorHash = consultaPorHash;
        this.consultarTodos = consultarTodos;
    }

    @GetMapping("/{hash}")
    public ResponseEntity<RetornoPadraoDto> buscarPorHash(@PathVariable String hash) {
        Curso curso = consultaPorHash.executar(hash, Curso.class);
        CursoDto cursoDto = Mapper.parseObject(curso, CursoDto.class);
//      TODO: adicionar hateoas

        RetornoPadraoDto retornoSucessoDto = new RetornoPadraoDto(
                MensagensRetorno.CONTEUDO_ENCONTRADO_COM_SUCESSO.getMensagem(),
                HttpStatus.OK.value(),
                cursoDto
        );
        return ResponseEntity.ok(retornoSucessoDto);
    }

    @GetMapping
    public ResponseEntity<RetornoPadraoComPaginacaoDto> buscarTodos(@PageableDefault(sort = "dataCadastro", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Curso> cursos = consultarTodos.executar(pageable, Curso.class);
        Page<CursoDto> cursosDtos = cursos.map(curso -> Mapper.parseObject(curso, CursoDto.class));

//        TODO: adicionar hateoas aos conteudos

        RetornoPadraoComPaginacaoDto retornoSucessoDto = new RetornoPadraoComPaginacaoDto(
                MensagensRetorno.BUSCA_REALIZADA_COM_SUCESSO.getMensagem(),
                HttpStatus.OK.value(),
                cursosDtos.getContent(),
                cursosDtos.getPageable().getPageNumber(),
                cursosDtos.getSize(),
                cursosDtos.getTotalElements(),
                cursosDtos.getTotalPages(),
                pageable.getSort().toString()
        );

        HateoasPaginacao.addHateoas(retornoSucessoDto,cursos);

        return ResponseEntity.ok(retornoSucessoDto);
    }
}
