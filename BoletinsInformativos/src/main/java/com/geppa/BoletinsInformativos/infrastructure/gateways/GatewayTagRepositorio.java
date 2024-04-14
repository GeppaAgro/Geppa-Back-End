package com.geppa.BoletinsInformativos.infrastructure.gateways;

import com.geppa.BoletinsInformativos.domain.classes.Tag;
import com.geppa.BoletinsInformativos.infrastructure.model.TagModel;
import com.geppa.BoletinsInformativos.infrastructure.persistencia.TagRepositorio;
import com.geppa.BoletinsInformativos.util.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public void deletarPorNome(Tag tag) {
        tagRepositorio.delete(Mapper.parseObject(tag, TagModel.class));
    }

    public Long verificaUtilizacaoDeTagPorConteudos(Tag tag) {
        return tagRepositorio.verificaUtilizacaoDeTagPorConteudos(Mapper.parseObject(tag, TagModel.class));
    }

    public Optional<Tag> buscar(String nome) {
        Optional<TagModel> tagModel = tagRepositorio.findByNome(nome);
       return tagModel.map(tag -> Mapper.parseObject(tag, Tag.class));
    }

    public Optional<Tag> buscarPorId(UUID id) {
        Optional<TagModel> tagModel = tagRepositorio.findById(id);
        return tagModel.map(tag -> Mapper.parseObject(tag, Tag.class));
    }

    public Optional<Tag> buscarDuplicado(Tag tag) {
        Optional<TagModel> tagModel = tagRepositorio.findByNome(tag.getNome());
        return tagModel.map(tagmd -> Mapper.parseObject(tagmd, Tag.class));
    }

    public Tag salvar(Tag tag) {
        TagModel tagModel = Mapper.parseObject(tag, TagModel.class);
        return Mapper.parseObject(tagRepositorio.save(tagModel), Tag.class);
    }
}
