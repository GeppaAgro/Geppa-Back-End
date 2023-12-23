package com.geppa.BoletinsInformativos.infrastructure.persistencia.conteudos;


import com.geppa.BoletinsInformativos.infrastructure.model.conteudos.NoticiaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NoticiaRepositorio extends JpaRepository<NoticiaModel, UUID> {
}
