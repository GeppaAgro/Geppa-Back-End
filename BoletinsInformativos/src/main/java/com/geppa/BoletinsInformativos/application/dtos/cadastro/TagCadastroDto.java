package com.geppa.BoletinsInformativos.application.dtos.cadastro;

import org.springframework.hateoas.RepresentationModel;

import java.util.UUID;

public class TagCadastroDto extends RepresentationModel<TagCadastroDto> {
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
