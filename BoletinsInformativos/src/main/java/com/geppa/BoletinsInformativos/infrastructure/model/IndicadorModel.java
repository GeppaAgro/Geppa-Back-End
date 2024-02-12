package com.geppa.BoletinsInformativos.infrastructure.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "indicadores")
public class IndicadorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid2")
    @Column(name = "ind_id", columnDefinition = "uuid")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ind_bol_id")
    private BoletimInformativoModel boletimInformativo;

    @Column(name = "ind_nome")
    private String nome;

    @Column(name = "ind_unidade_medida")
    private String unidadeMedida;

    @Column(name = "ind_valor")
    private Double valor;

    @Column(name = "ind_data")
    private LocalDate data;

    public IndicadorModel() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BoletimInformativoModel getBoletimInformativo() {
        return boletimInformativo;
    }

    public void setBoletimInformativo(BoletimInformativoModel boletimInformativo) {
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
