package com.geppa.BoletinsInformativos.infrastructure.model.conteudos;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "eventos")
public class EventoModel extends ConteudoModel {

    @Column(name = "eve_local")
    private String local;

    @Column(name = "eve_preco")
    private Double preco;

    @Column(name = "eve_data_hora_inicio")
    private LocalDateTime dataHoraInicio;

    @Column(name = "eve_data_hora_fim")
    private LocalDateTime dataHoraFim;

    public EventoModel() {
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }
}