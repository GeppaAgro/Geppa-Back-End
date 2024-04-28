package com.geppa.BoletinsInformativos.domain.classes.conteudos;

import com.geppa.BoletinsInformativos.domain.classes.Autor;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Artigo extends Conteudo {

    @NotNull(message = "A data de publicação é obrigatória")
    @FutureOrPresent(message = "A data de publicação deve ser no futuro ou presente")
    private LocalDate dataPublicacao;

    @NotNull(message = "Os autores são obrigatórios")
    @Size(min = 1, message = "Deve haver pelo menos um autor")
    private List<Autor> autores = new ArrayList<>();

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
}
