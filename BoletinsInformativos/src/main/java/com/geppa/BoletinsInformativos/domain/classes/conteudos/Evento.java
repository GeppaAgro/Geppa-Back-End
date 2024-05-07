package com.geppa.BoletinsInformativos.domain.classes.conteudos;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class Evento extends Conteudo {

    @Size(min = 5, message = "{evento.local.size}")
    private String local;

    @PositiveOrZero(message = "{evento.preco.positive}")
    private Double preco;

    @FutureOrPresent(message = "{evento.dataHoraInicio.futureOrPresent}")
    private LocalDateTime dataHoraInicio;

    @FutureOrPresent(message = "{evento.dataHoraFim.futureOrPresent}")
    private LocalDateTime dataHoraFim;

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
