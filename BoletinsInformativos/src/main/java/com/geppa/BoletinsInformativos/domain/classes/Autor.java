package com.geppa.BoletinsInformativos.domain.classes;

import com.geppa.BoletinsInformativos.domain.classes.conteudos.Artigo;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class Autor {

    private UUID id;
    private Artigo artigo;

    @NotNull(message = "{autor.nome.notNull}")
    @Size(min = 3, message = "{autor.nome.size}")
    private String nome;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Artigo getArtigo() {
        return artigo;
    }

    public void setArtigo(Artigo artigo) {
        this.artigo = artigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
