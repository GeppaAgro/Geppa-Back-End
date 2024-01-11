package com.geppa.BoletinsInformativos.application.dtos.retorno.conteudos;

public class VideoDto extends ConteudoDto {

    private boolean youtube;

    public boolean isYoutube() {
        return youtube;
    }

    public void setYoutube(boolean youtube) {
        this.youtube = youtube;
    }
}
