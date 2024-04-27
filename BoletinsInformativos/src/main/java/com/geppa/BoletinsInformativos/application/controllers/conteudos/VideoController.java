package com.geppa.BoletinsInformativos.application.controllers.conteudos;

import com.geppa.BoletinsInformativos.application.dtos.cadastro.conteudos.VideoCadastroDto;
import com.geppa.BoletinsInformativos.application.dtos.padrao.RetornoPadraoComPaginacaoDto;
import com.geppa.BoletinsInformativos.application.dtos.padrao.RetornoPadraoDto;
import com.geppa.BoletinsInformativos.application.dtos.retorno.conteudos.VideoDto;
import com.geppa.BoletinsInformativos.application.dtos.filters.FiltroGenericoDto;
import com.geppa.BoletinsInformativos.application.hateoas.HateoasPaginacao;
import com.geppa.BoletinsInformativos.domain.classes.conteudos.Video;
import com.geppa.BoletinsInformativos.domain.useCases.genericos.ConsultaPorHash;
import com.geppa.BoletinsInformativos.domain.useCases.genericos.ConsultarTodos;
import com.geppa.BoletinsInformativos.domain.useCases.genericos.ValidarConteudo;
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
@RequestMapping("/videos")
public class VideoController {

    private final ConsultaPorHash consultaPorHash;
    private final ConsultarTodos consultarTodos;
    private final ValidarConteudo validarConteudo;

    public VideoController(ConsultaPorHash consultaPorHash, ConsultarTodos consultarTodos, ValidarConteudo validarConteudo) {
        this.consultaPorHash = consultaPorHash;
        this.consultarTodos = consultarTodos;
        this.validarConteudo = validarConteudo;
    }

    @GetMapping("/{hash}")
    public ResponseEntity<RetornoPadraoDto> buscarPorHash(@PathVariable String hash) {
        Video video = consultaPorHash.executar(hash, Video.class);
        VideoDto videoDto = Mapper.parseObject(video, VideoDto.class);
//      TODO: adicionar hateoas

        RetornoPadraoDto retornoSucessoDto = new RetornoPadraoDto(
                MensagensRetorno.CONTEUDO_ENCONTRADO_COM_SUCESSO.getMensagem(),
                HttpStatus.OK.value(),
                videoDto
        );
        return ResponseEntity.ok(retornoSucessoDto);
    }

    @GetMapping
    public ResponseEntity<RetornoPadraoComPaginacaoDto> buscarTodos(@PageableDefault(sort = "dataCadastro", direction = Sort.Direction.DESC) Pageable pageable,
                                                                    @ModelAttribute FiltroGenericoDto filtro) {
        Page<Video> videos = consultarTodos.executar(pageable, filtro, Video.class);
        Page<VideoDto> videoDtos = videos.map(video -> Mapper.parseObject(video, VideoDto.class));

//        TODO: adicionar hateoas aos conteudos

        RetornoPadraoComPaginacaoDto retornoSucessoDto = new RetornoPadraoComPaginacaoDto(
                MensagensRetorno.BUSCA_REALIZADA_COM_SUCESSO.getMensagem(),
                HttpStatus.OK.value(),
                videoDtos.getContent(),
                videoDtos.getPageable().getPageNumber(),
                videoDtos.getSize(),
                videoDtos.getTotalElements(),
                videoDtos.getTotalPages(),
                pageable.getSort().toString()
        );

        HateoasPaginacao.addHateoas(retornoSucessoDto, videos);

        return ResponseEntity.ok(retornoSucessoDto);
    }


    @PostMapping("/validar")
    public ResponseEntity<RetornoPadraoDto> validarVideo(@RequestBody VideoCadastroDto videoDto) {
        Video video = Mapper.parseObject(videoDto, Video.class);
        validarConteudo.executar(video);
        return ResponseEntity.ok(new RetornoPadraoDto(MensagensRetorno.CONTEUDO_VALIDADO_COM_SUCESSO.getMensagem(), HttpStatus.OK.value()));
    }
}
