package com.geppa.BoletinsInformativos.infrastructure.persistencia;

import com.geppa.BoletinsInformativos.infrastructure.model.conteudos.ArtigoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ArtigoRepository extends JpaRepository<ArtigoModel, UUID> {
}
