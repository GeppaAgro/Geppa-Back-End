package com.geppa.BoletinsInformativos.application.dtos.retorno;

import java.util.UUID;

public class AutorDto {
    private UUID id;
    private String nome;

    public AutorDto() {
    }

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
