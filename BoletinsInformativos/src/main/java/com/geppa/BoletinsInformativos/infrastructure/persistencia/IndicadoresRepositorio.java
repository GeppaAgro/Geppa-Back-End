package com.geppa.BoletinsInformativos.infrastructure.persistencia;

import com.geppa.BoletinsInformativos.infrastructure.model.IndicadorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IndicadoresRepositorio extends JpaRepository<IndicadorModel, UUID> {
}
