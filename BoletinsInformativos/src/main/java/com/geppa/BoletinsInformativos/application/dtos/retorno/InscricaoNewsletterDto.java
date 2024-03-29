package com.geppa.BoletinsInformativos.application.dtos.retorno;

import org.springframework.hateoas.RepresentationModel;

import java.time.Instant;

public class InscricaoNewsletterDto extends RepresentationModel<InscricaoNewsletterDto> {

    private String id;
    private Instant dataCadastro;
    private Instant dataAtualizacao;
    private String email;
    private boolean ativo;

    public InscricaoNewsletterDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Instant dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Instant getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Instant dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
