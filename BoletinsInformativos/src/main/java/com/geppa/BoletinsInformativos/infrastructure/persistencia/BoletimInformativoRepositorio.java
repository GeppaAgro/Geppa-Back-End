package com.geppa.BoletinsInformativos.infrastructure.persistencia;

import com.geppa.BoletinsInformativos.infrastructure.model.BoletimInformativoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BoletimInformativoRepositorio extends JpaRepository<BoletimInformativoModel, UUID> {

    @Query("SELECT b FROM BoletimInformativoModel b WHERE b.edicao = ?1")
    Optional<BoletimInformativoModel> buscarPorEdicao(String edicao);
}
