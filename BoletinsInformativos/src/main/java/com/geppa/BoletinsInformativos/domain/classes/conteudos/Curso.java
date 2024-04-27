package com.geppa.BoletinsInformativos.domain.classes.conteudos;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public class Curso extends Conteudo {

    @FutureOrPresent(message = "O prazo de inscrição deve ser no futuro ou presente")
    private LocalDateTime prazoInscricao;

    @Positive(message = "O preço deve ser positivo")
    private Double preco;

    @Positive(message = "A duração em horas deve ser positiva")
    private Integer duracaoEmHoras;

    public LocalDateTime getPrazoInscricao() {
        return prazoInscricao;
    }

    public void setPrazoInscricao(LocalDateTime prazoInscricao) {
        this.prazoInscricao = prazoInscricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getDuracaoEmHoras() {
        return duracaoEmHoras;
    }

    public void setDuracaoEmHoras(Integer duracaoEmHoras) {
        this.duracaoEmHoras = duracaoEmHoras;
    }
}
