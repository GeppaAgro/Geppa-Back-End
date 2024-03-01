package com.geppa.BoletinsInformativos.infrastructure.model;

import com.geppa.BoletinsInformativos.infrastructure.model.conteudos.ArtigoModel;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "autores")
public class AutorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid2")
    @Column(name = "aut_id", columnDefinition = "uuid")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "aut_art_id")
    private ArtigoModel artigo;

    @Column(name = "aut_nome")
    private String nome;

    public AutorModel() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ArtigoModel getArtigo() {
        return artigo;
    }

    public void setArtigo(ArtigoModel artigo) {
        this.artigo = artigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
