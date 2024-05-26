package com.geppa.BoletinsInformativos.infrastructure.gateways;

import com.geppa.BoletinsInformativos.domain.classes.InscricaoNewsletter;
import com.geppa.BoletinsInformativos.domain.exceptions.MapperExcecao;
import com.geppa.BoletinsInformativos.infrastructure.model.InscricaoNewsletterModel;
import com.geppa.BoletinsInformativos.infrastructure.persistencia.InscricaoNewsletterRepositorio;
import com.geppa.BoletinsInformativos.util.enums.messages.MensagensExcecao;
import com.geppa.BoletinsInformativos.util.mapper.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GatewayInscricaoNewsletterRepositorio {

    private final InscricaoNewsletterRepositorio inscricaoNewsletterRepositorio;

    public GatewayInscricaoNewsletterRepositorio(InscricaoNewsletterRepositorio inscricaoNewsletterRepositorio) {
        this.inscricaoNewsletterRepositorio = inscricaoNewsletterRepositorio;
    }

    public Optional<InscricaoNewsletter> buscarPorEmail(String email) {
        return inscricaoNewsletterRepositorio.findByEmail(email)
                .map(inscricaoNewsletterModel -> {
                    try {
                        return Mapper.parseObject(inscricaoNewsletterModel, InscricaoNewsletter.class);
                    } catch (Exception e) {
                        throw new MapperExcecao(MensagensExcecao.FALHA_CONVERSAO_MODELO_DOMINIO.getMensagem());
                    }
                });
    }

    public InscricaoNewsletter salvar(InscricaoNewsletter inscricaoNewsletter) {
        try {
            return Mapper.parseObject(inscricaoNewsletterRepositorio.save(Mapper.parseObject(inscricaoNewsletter, InscricaoNewsletterModel.class)), InscricaoNewsletter.class);
        } catch (Exception e) {
            throw new MapperExcecao(MensagensExcecao.FALHA_CONVERSAO_MODELO_DOMINIO.getMensagem());
        }
    }

    public Page<InscricaoNewsletter> buscarAtivos(Pageable pageable) {
        Page<InscricaoNewsletterModel> modelos = inscricaoNewsletterRepositorio.findByAtivoTrue(pageable);
        return modelos.map(modelo -> {
            try {
                return Mapper.parseObject(modelo, InscricaoNewsletter.class);
            } catch (Exception e) {
                throw new RuntimeException("Falha na conversão de modelo para domínio");
            }
        });
    }
}
