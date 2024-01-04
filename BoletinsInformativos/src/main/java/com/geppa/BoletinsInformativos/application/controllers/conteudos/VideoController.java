package com.geppa.BoletinsInformativos.application.controllers.conteudos;

import com.geppa.BoletinsInformativos.application.dtos.retorno.RetornoPadraoDto;
import com.geppa.BoletinsInformativos.application.dtos.retorno.conteudos.VideoDto;
import com.geppa.BoletinsInformativos.domain.classes.conteudos.Video;
import com.geppa.BoletinsInformativos.domain.useCases.genericos.ConsultaPorHash;
import com.geppa.BoletinsInformativos.util.mapper.Mapper;
import com.geppa.BoletinsInformativos.util.messages.MensagensRetorno;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/videos")
public class VideoController {

    private final ConsultaPorHash consultaPorHash;

    public VideoController(ConsultaPorHash consultaPorHash) {
        this.consultaPorHash = consultaPorHash;
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
}
