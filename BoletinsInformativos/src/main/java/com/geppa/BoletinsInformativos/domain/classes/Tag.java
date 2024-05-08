package com.geppa.BoletinsInformativos.domain.classes;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class Tag {

    private UUID id;

    @NotBlank(message = "{mensagens.tag.nome.obrigatorio}")
    @Size(min = 3, max = 30, message = "{mensagens.tag.nome.tamanho}")
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
