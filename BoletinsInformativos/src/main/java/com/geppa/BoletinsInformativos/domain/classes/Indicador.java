package com.geppa.BoletinsInformativos.domain.classes;

import java.time.LocalDate;
import java.util.UUID;

public class Indicador {

    private UUID id;
    private BoletimInformativo boletimInformativo;
    private String nome;
    private String unidadeMedida;
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
