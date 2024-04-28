package com.geppa.BoletinsInformativos.application.dtos.cadastro;

public class AutorCadastroDto {

    private String nome;

    public AutorCadastroDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
