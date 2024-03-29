package com.geppa.BoletinsInformativos.application.dtos.padrao;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.geppa.BoletinsInformativos.util.UrlUtils;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

public class RetornoPadraoDto extends RepresentationModel<RetornoPadraoDto> {
    @JsonFormat(pattern = "dd/MM/yy HH:mm:ss", timezone = "America/Sao_Paulo")
    private LocalDateTime dataHora = LocalDateTime.now();
    private String mensagem;
    private int status;
    private String path;
    private Object dados;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object errosValidacao;

    public RetornoPadraoDto(String mensagem, int status, Object dados) {
        this.mensagem = mensagem;
        this.status = status;
        this.dados = dados;
        this.path = UrlUtils.obterUrl();
    }

    public RetornoPadraoDto(String mensagem, int status) {
        this.mensagem = mensagem;
        this.status = status;
        this.path = UrlUtils.obterUrl();
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Object getDados() {
        return dados;
    }

    public void setDados(Object dados) {
        this.dados = dados;
    }

    public Object getErrosValidacao() {
        return errosValidacao;
    }

    public void setErrosValidacao(Object errosValidacao) {
        this.errosValidacao = errosValidacao;
    }
}
