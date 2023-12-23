package com.geppa.BoletinsInformativos.application.controllers.conteudos;

import com.geppa.BoletinsInformativos.application.dtos.retorno.RetornoPadraoDto;
import com.geppa.BoletinsInformativos.application.dtos.retorno.conteudos.ArtigoDto;
import com.geppa.BoletinsInformativos.domain.classes.conteudos.Artigo;
import com.geppa.BoletinsInformativos.domain.useCases.genericos.ConsultaPorHash;
import com.geppa.BoletinsInformativos.util.mapper.Mapper;
import com.geppa.BoletinsInformativos.util.messages.MensagensRetorno;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artigos")
public class ArtigoController {

    private final ConsultaPorHash consultaPorHash;

    public ArtigoController(ConsultaPorHash consultaPorHash) {
        this.consultaPorHash = consultaPorHash;
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
}
