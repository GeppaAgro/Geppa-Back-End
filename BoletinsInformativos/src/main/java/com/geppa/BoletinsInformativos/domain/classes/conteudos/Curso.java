package com.geppa.BoletinsInformativos.domain.classes.conteudos;

import java.time.LocalDateTime;

public class Curso extends Conteudo{

    private LocalDateTime prazoInscricao;
    private Double preco;
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
