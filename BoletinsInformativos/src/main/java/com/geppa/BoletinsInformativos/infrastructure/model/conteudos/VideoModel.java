package com.geppa.BoletinsInformativos.infrastructure.model.conteudos;

import com.geppa.BoletinsInformativos.infrastructure.model.BoletimInformativoModel;
import com.geppa.BoletinsInformativos.infrastructure.model.TagModel;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "videos")
public class VideoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid2")
    @Column(name = "vid_id", columnDefinition = "uuid")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vid_bol_id")
    private BoletimInformativoModel boletimInformativo;

    @Column(name = "vid_titulo")
    private String titulo;

    @Column(name = "vid_descricao")
    private String descricao;

    @Column(name = "vid_link")
    private String link;

    @Column(name = "vid_youtube")
    private boolean youtube;

    @Column(name = "vid_data_cadastro")
    private Instant dataCadastro;

    @Column(name = "vid_data_atualizacao")
    private Instant dataAtualizacao;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "videos_tags",
            joinColumns = @JoinColumn(name = "vid_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<TagModel> tags;

    public VideoModel() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BoletimInformativoModel getBoletimInformativo() {
        return boletimInformativo;
    }

    public void setBoletimInformativo(BoletimInformativoModel boletimInformativo) {
        this.boletimInformativo = boletimInformativo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean isYoutube() {
        return youtube;
    }

    public void setYoutube(boolean youtube) {
        this.youtube = youtube;
    }

    public Instant getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Instant dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Instant getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Instant dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public List<TagModel> getTags() {
        return tags;
    }

    public void setTags(List<TagModel> tags) {
        this.tags = tags;
    }
}
