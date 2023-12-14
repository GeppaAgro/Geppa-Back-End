package com.geppa.BoletinsInformativos.infrastructure.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tags")
public class TagModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid2")
    @Column(name = "tag_id", columnDefinition = "uuid")
    private UUID id;

    @Column(name = "tag_nome")
    private String nome;

    public TagModel() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
