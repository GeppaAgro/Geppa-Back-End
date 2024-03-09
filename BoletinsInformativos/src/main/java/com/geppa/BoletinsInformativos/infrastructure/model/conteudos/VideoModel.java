package com.geppa.BoletinsInformativos.infrastructure.model.conteudos;

import jakarta.persistence.*;

@Entity
@Table(name = "videos")
public class VideoModel extends ConteudoModel {

    @Column(name = "vid_youtube")
    private boolean youtube;

    public VideoModel() {
    }

    public boolean isYoutube() {
        return youtube;
    }

    public void setYoutube(boolean youtube) {
        this.youtube = youtube;
    }
}
