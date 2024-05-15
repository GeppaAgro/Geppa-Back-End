package com.geppa.BoletinsInformativos.domain.classes;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.util.UUID;

public class Indicador {

    private UUID id;
    private BoletimInformativo boletimInformativo;
    @NotBlank(message = "{indicador.nome.notBlank}")
    private String nome;

    @NotBlank(message = "{indicador.nome.unidadeMedida.notBlank}")
    private String unidadeMedida;

    @NotNull(message = "{indicador.nome.valor.notNull}")
    @Positive(message = "{indicador.nome.valor.positive}")
    private Double valor;
    private LocalDate data;

    public Indicador() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BoletimInformativo getBoletimInformativo() {
        return boletimInformativo;
    }

    public void setBoletimInformativo(BoletimInformativo boletimInformativo) {
        this.boletimInformativo = boletimInformativo;
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
