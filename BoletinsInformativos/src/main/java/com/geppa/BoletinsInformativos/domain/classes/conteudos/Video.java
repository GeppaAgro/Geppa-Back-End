package com.geppa.BoletinsInformativos.domain.classes.conteudos;

import jakarta.validation.constraints.NotNull;

public class Video extends Conteudo {

    @NotNull(message = "{video.youtube.notNull}")
    private boolean youtube;

    public boolean isYoutube() {
        return youtube;
    }

    public void setYoutube(boolean youtube) {
        this.youtube = youtube;
    }
}
