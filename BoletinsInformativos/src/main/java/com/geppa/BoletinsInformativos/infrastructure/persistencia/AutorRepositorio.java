package com.geppa.BoletinsInformativos.infrastructure.persistencia;

import com.geppa.BoletinsInformativos.infrastructure.model.AutorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepositorio extends JpaRepository<AutorModel, Long> {
}
