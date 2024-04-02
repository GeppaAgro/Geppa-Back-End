package com.geppa.BoletinsInformativos.domain.useCases.tags;

import com.geppa.BoletinsInformativos.domain.classes.Tag;
import com.geppa.BoletinsInformativos.domain.exceptions.BuscaInvalidaExcecao;
import com.geppa.BoletinsInformativos.infrastructure.gateways.GatewayTagRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarTagPorNome {

    private final GatewayTagRepositorio gatewayTagRepositorio;

    public BuscarTagPorNome(GatewayTagRepositorio gatewayTagRepositorio) {
        this.gatewayTagRepositorio = gatewayTagRepositorio;
    }

    public List<Tag> executar(String nome) {

        if (nome == null || nome.isEmpty())
            throw new BuscaInvalidaExcecao("Nome da tag não pode ser nulo ou vazio");

        if (!nome.matches("^[a-zA-Z0-9]*$"))
            throw new BuscaInvalidaExcecao("Nome da tag contém caracteres inválidos. Apenas letras e números são permitidos.");

        return gatewayTagRepositorio.consultarPorNome(nome);
    }

}
