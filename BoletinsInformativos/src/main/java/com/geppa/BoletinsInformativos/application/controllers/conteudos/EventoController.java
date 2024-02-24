package com.geppa.BoletinsInformativos.application.controllers.conteudos;

import com.geppa.BoletinsInformativos.application.dtos.padrao.RetornoPadraoComPaginacaoDto;
import com.geppa.BoletinsInformativos.application.dtos.padrao.RetornoPadraoDto;
import com.geppa.BoletinsInformativos.application.dtos.retorno.conteudos.EventoDto;
import com.geppa.BoletinsInformativos.application.dtos.filters.FiltroGenericoDto;
import com.geppa.BoletinsInformativos.application.hateoas.HateoasPaginacao;
import com.geppa.BoletinsInformativos.domain.classes.conteudos.Evento;
import com.geppa.BoletinsInformativos.domain.useCases.genericos.ConsultaPorHash;
import com.geppa.BoletinsInformativos.domain.useCases.genericos.ConsultarTodos;
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
@RequestMapping("/eventos")
public class EventoController {

    private final ConsultaPorHash consultaPorHash;
    private final ConsultarTodos consultarTodos;

    public EventoController(ConsultaPorHash consultaPorHash, ConsultarTodos consultarTodos) {
        this.consultaPorHash = consultaPorHash;
        this.consultarTodos = consultarTodos;
    }

    @GetMapping("/{hash}")
    public ResponseEntity<RetornoPadraoDto> buscarPorHash(@PathVariable String hash) {
        Evento evento = consultaPorHash.executar(hash, Evento.class);
        EventoDto eventoDto = Mapper.parseObject(evento, EventoDto.class);
//      TODO: adicionar hateoas

        RetornoPadraoDto retornoSucessoDto = new RetornoPadraoDto(
                MensagensRetorno.CONTEUDO_ENCONTRADO_COM_SUCESSO.getMensagem(),
                HttpStatus.OK.value(),
                eventoDto
        );
        return ResponseEntity.ok(retornoSucessoDto);
    }

    @GetMapping
    public ResponseEntity<RetornoPadraoComPaginacaoDto> buscarTodos(@PageableDefault(sort = "dataCadastro", direction = Sort.Direction.DESC) Pageable pageable,
                                                                    @ModelAttribute FiltroGenericoDto filtro) {
        Page<Evento> eventos = consultarTodos.executar(pageable,filtro, Evento.class);
        Page<EventoDto> eventosDtos = eventos.map(evento -> Mapper.parseObject(evento, EventoDto.class));

//        TODO: adicionar hateoas aos conteudos

        RetornoPadraoComPaginacaoDto retornoSucessoDto = new RetornoPadraoComPaginacaoDto(
                MensagensRetorno.BUSCA_REALIZADA_COM_SUCESSO.getMensagem(),
                HttpStatus.OK.value(),
                eventosDtos.getContent(),
                eventosDtos.getPageable().getPageNumber(),
                eventosDtos.getSize(),
                eventosDtos.getTotalElements(),
                eventosDtos.getTotalPages(),
                pageable.getSort().toString()
        );

        HateoasPaginacao.addHateoas(retornoSucessoDto, eventos);

        return ResponseEntity.ok(retornoSucessoDto);
    }

}
