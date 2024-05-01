package com.geppa.BoletinsInformativos.application.dtos.cadastro.conteudos;

import java.time.LocalDateTime;

public class CursoCadastroDto extends ConteudoCadastroDto {
    private LocalDateTime prazoInscricao;
    private Double preco;
    private Integer duracaoEmHoras;

    public CursoCadastroDto(LocalDateTime prazoInscricao, Double preco, Integer duracaoEmHoras) {
        this.prazoInscricao = prazoInscricao;
        this.preco = preco;
        this.duracaoEmHoras = duracaoEmHoras;
    }

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
