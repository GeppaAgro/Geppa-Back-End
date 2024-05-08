package com.geppa.BoletinsInformativos.application.dtos.cadastro;

import org.springframework.hateoas.RepresentationModel;

import java.util.UUID;

public class BoletimInformativoCadastroDto extends RepresentationModel<BoletimInformativoCadastroDto> {
    private UUID id;

    public BoletimInformativoCadastroDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}
