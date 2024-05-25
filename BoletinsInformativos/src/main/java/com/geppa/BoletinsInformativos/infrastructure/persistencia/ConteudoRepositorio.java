package com.geppa.BoletinsInformativos.infrastructure.persistencia;

import com.geppa.BoletinsInformativos.infrastructure.model.conteudos.ConteudoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConteudoRepositorio extends JpaRepository<ConteudoModel, UUID> {
}
