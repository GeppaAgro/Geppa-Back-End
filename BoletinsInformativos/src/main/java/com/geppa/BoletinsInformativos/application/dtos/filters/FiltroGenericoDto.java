package com.geppa.BoletinsInformativos.application.dtos.filters;

import java.time.LocalDate;
import java.util.List;

public class FiltroGenericoDto {
    private LocalDate dataMinima;
    private LocalDate dataMaxima;
    private List<String> tags;

    public FiltroGenericoDto(LocalDate dataMinima, LocalDate dataMaxima, List<String> tags) {
        this.dataMinima = dataMinima;
        this.dataMaxima = dataMaxima;
        this.tags = tags;
    }

    public FiltroGenericoDto() {
    }

    public LocalDate getDataMinima() {
        return dataMinima;
    }

    public LocalDate getDataMaxima() {
        return dataMaxima;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setDataMinima(LocalDate dataMinima) {
        this.dataMinima = dataMinima;
    }

    public void setDataMaxima(LocalDate dataMaxima) {
        this.dataMaxima = dataMaxima;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
