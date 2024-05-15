package com.geppa.BoletinsInformativos.application.dtos.cadastro;

public class IndicadorCadastroDto {

    private String nome;
    private String unidadeMedida;
    private Double valor;

    public IndicadorCadastroDto() {
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
}
