package com.geppa.BoletinsInformativos.application.dtos.retorno;

import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;
import java.util.UUID;

public class IndicadorDto extends RepresentationModel<IndicadorDto> {
    private UUID id;
    private String boletimInformativoEdicao;
    private String nome;
    private String unidadeMedida;
    private Double valor;
    private LocalDate data;

    public IndicadorDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getBoletimInformativoEdicao() {
        return boletimInformativoEdicao;
    }

    public void setBoletimInformativoEdicao(String boletimInformativoEdicao) {
        this.boletimInformativoEdicao = boletimInformativoEdicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
