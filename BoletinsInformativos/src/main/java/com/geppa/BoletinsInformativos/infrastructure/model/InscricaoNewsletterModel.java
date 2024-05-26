package com.geppa.BoletinsInformativos.infrastructure.model;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "inscricao_newsletter")
public class InscricaoNewsletterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid2")
    @Column(name = "inl_id", columnDefinition = "uuid")
    private UUID id;

    @Column(name = "inl_data_cadastro")
    private Instant dataCadastro;

    @Column(name = "inl_data_atualizacao")
    private Instant dataAtualizacao;

    @Column(name = "inl_email")
    private String email;

    @Column(name = "inl_ativo")
    private boolean ativo;

    public InscricaoNewsletterModel() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
