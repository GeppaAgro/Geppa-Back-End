package com.geppa.BoletinsInformativos.application.dtos.retorno;

import org.springframework.hateoas.RepresentationModel;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public class BoletimInformativoDto extends RepresentationModel<BoletimInformativoDto> {
    private UUID id;
    private String edicao;
    private LocalDate dataPublicacao;
    private Instant dataAtualizacao;
    private Instant dataCadastro;

    public BoletimInformativoDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Instant getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Instant dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Instant getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Instant dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
