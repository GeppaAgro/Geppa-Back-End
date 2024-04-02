package com.geppa.BoletinsInformativos.infrastructure.gateways;

import com.geppa.BoletinsInformativos.domain.classes.Tag;
import com.geppa.BoletinsInformativos.infrastructure.model.TagModel;
import com.geppa.BoletinsInformativos.infrastructure.persistencia.TagRepositorio;
import com.geppa.BoletinsInformativos.util.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GatewayTagRepositorio {

    private final TagRepositorio tagRepositorio;

    public GatewayTagRepositorio(TagRepositorio tagRepositorio) {
        this.tagRepositorio = tagRepositorio;
    }

    public List<Tag> consultarPorNome(String nome) {
        List<TagModel> tagModels = tagRepositorio.consultarPorNome(nome.toLowerCase());
        return Mapper.parseListObjects(tagModels, Tag.class);
    }
}
