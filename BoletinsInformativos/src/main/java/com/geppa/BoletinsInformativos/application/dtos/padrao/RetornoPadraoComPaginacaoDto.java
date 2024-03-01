package com.geppa.BoletinsInformativos.application.dtos.padrao;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"dataHora", "mensagem", "status", "path", "paginaAtual", "tamanhoPagina", "totalElementos", "totalPaginas", "ordenacao", "dados"})
public class RetornoPadraoComPaginacaoDto extends RetornoPadraoDto {
    private int paginaAtual;
    private int tamanhoPagina;
    private long totalElementos;
    private int totalPaginas;
    private String ordenacao;

    public RetornoPadraoComPaginacaoDto(String mensagem, int status, Object dados, int paginaAtual, int tamanhoPagina, long totalElementos, int totalPaginas, String ordenacao) {
        super(mensagem, status, dados);
        this.paginaAtual = paginaAtual;
        this.tamanhoPagina = tamanhoPagina;
        this.totalElementos = totalElementos;
        this.totalPaginas = totalPaginas;
        this.ordenacao = ordenacao;
    }

    public int getPaginaAtual() {
        return paginaAtual;
    }

    public void setPaginaAtual(int paginaAtual) {
        this.paginaAtual = paginaAtual;
    }

    public int getTamanhoPagina() {
        return tamanhoPagina;
    }

    public void setTamanhoPagina(int tamanhoPagina) {
        this.tamanhoPagina = tamanhoPagina;
    }

    public long getTotalElementos() {
        return totalElementos;
    }

    public void setTotalElementos(long totalElementos) {
        this.totalElementos = totalElementos;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public void setTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
    }

    public String getOrdenacao() {
        return ordenacao;
    }

    public void setOrdenacao(String ordenacao) {
        this.ordenacao = ordenacao;
    }
}
