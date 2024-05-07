package com.geppa.BoletinsInformativos.domain.classes.conteudos;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDateTime;

public class Curso extends Conteudo {

    @FutureOrPresent(message = "{curso.prazoInscricao.futureOrPresent}")
    private LocalDateTime prazoInscricao;

    @PositiveOrZero(message = "{curso.preco.positive}")
    private Double preco;

    @Positive(message = "{curso.duracaoEmHoras.positive}")
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
