package com.geppa.BoletinsInformativos.application.dtos.cadastro;

public class NewsletterPublicacaoDto {

    private String body;

    public NewsletterPublicacaoDto() {
    }

    public NewsletterPublicacaoDto(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }
}
