package com.geppa.BoletinsInformativos.application.dtos.cadastro.conteudos;

public class VideoCadastroDto extends ConteudoCadastroDto {

    private boolean youtube;

    public boolean isYoutube() {
        return youtube;
    }

    public void setYoutube(boolean youtube) {
        this.youtube = youtube;
    }
}
