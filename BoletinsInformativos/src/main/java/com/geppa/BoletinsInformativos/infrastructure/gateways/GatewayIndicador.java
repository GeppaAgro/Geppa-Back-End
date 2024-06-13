package com.geppa.BoletinsInformativos.infrastructure.gateways;

import com.geppa.BoletinsInformativos.domain.classes.Indicador;
import com.geppa.BoletinsInformativos.infrastructure.model.IndicadorModel;
import com.geppa.BoletinsInformativos.infrastructure.persistencia.IndicadoresRepositorio;
import com.geppa.BoletinsInformativos.util.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GatewayIndicador {

    private final IndicadoresRepositorio indicadoresRepositorio;

    public GatewayIndicador(IndicadoresRepositorio indicadoresRepositorio) {
        this.indicadoresRepositorio = indicadoresRepositorio;
    }

    public Optional<Indicador> buscarPorId(UUID id) {
        return indicadoresRepositorio.findById(id).map(
                indicadorModel -> Mapper.parseObject(indicadorModel, Indicador.class));
    }

    public Indicador salvar(Indicador indicador) {
        IndicadorModel indicadorModel = Mapper.parseObject(indicador, IndicadorModel.class);
        return Mapper.parseObject(indicadoresRepositorio.save(indicadorModel), Indicador.class);
    }

    public void deletar(Indicador indicador) {
        indicadoresRepositorio.delete(Mapper.parseObject(indicador, IndicadorModel.class));
    }
}
