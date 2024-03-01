package com.geppa.BoletinsInformativos.application.dtos.retorno;

import org.springframework.hateoas.RepresentationModel;

import java.util.UUID;

public class TagDto extends RepresentationModel<TagDto> {
    private UUID id;
    private String nome;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
