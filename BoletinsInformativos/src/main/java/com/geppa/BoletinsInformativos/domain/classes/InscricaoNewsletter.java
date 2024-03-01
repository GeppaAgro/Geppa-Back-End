package com.geppa.BoletinsInformativos.domain.classes;

import com.geppa.BoletinsInformativos.util.annotations.AutoPreenchimentoAtualizacao;
import com.geppa.BoletinsInformativos.util.annotations.AutoPreenchimentoCadastro;
import com.geppa.BoletinsInformativos.util.enums.TipoPreenchimento;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.Instant;
import java.util.UUID;

public class InscricaoNewsletter {

    private UUID id;

    @AutoPreenchimentoCadastro(TipoPreenchimento.INSTANT)
    private Instant dataCadastro;

    @AutoPreenchimentoCadastro(TipoPreenchimento.INSTANT)
    @AutoPreenchimentoAtualizacao(TipoPreenchimento.INSTANT)
    private Instant dataAtualizacao;

    @Email(message = "{mensagens.email.invalido}")
    @NotBlank(message = "{mensagens.email.obrigatorio}")
    private String email;

    @AutoPreenchimentoCadastro(value = TipoPreenchimento.BOOLEAN, booleanValue = true)
    private boolean ativo;

    public InscricaoNewsletter() {
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
