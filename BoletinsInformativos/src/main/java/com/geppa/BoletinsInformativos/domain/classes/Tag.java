package com.geppa.BoletinsInformativos.domain.classes;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;

public class Tag {

    private UUID id;

    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    @NotBlank
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
