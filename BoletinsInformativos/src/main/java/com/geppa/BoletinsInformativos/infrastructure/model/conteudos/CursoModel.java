package com.geppa.BoletinsInformativos.infrastructure.model.conteudos;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "cursos")
public class CursoModel extends ConteudoModel {

    @Column(name = "cur_prazo_inscricao")
    private LocalDateTime prazoInscricao;

    @Column(name = "cur_preco")
    private Double preco;

    @Column(name = "cur_duracao_em_horas")
    private Integer duracaoEmHoras;

    public CursoModel() {
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