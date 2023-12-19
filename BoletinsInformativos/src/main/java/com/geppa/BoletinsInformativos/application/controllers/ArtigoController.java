package com.geppa.BoletinsInformativos.application.controllers;

import com.geppa.BoletinsInformativos.application.dtos.retorno.conteudos.ArtigoDTO;
import com.geppa.BoletinsInformativos.domain.classes.conteudos.Artigo;
import com.geppa.BoletinsInformativos.domain.useCases.artigo.ArtigoConsultaPorHash;
import com.geppa.BoletinsInformativos.util.mapper.Mapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artigos")
public class ArtigoController {

    private final ArtigoConsultaPorHash artigoConsultaPorHash;

    public ArtigoController(ArtigoConsultaPorHash artigoConsultaPorHash) {
        this.artigoConsultaPorHash = artigoConsultaPorHash;
    }

    @GetMapping("/{hash}")
    public ResponseEntity<?> buscarPorHash(@PathVariable String hash) {
        Artigo artigo = artigoConsultaPorHash.executar(hash);
        ArtigoDTO artigoDTO = Mapper.parseObject(artigo, ArtigoDTO.class);
//      TODO: adicionar hateoas
        return ResponseEntity.ok(artigoDTO);
    }

}
