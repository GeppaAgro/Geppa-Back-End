package com.geppa.BoletinsInformativos.infrastructure.model.conteudos;

import com.geppa.BoletinsInformativos.infrastructure.model.BoletimInformativoModel;
import com.geppa.BoletinsInformativos.infrastructure.model.TagModel;
import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "cursos")
public class CursoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid2")
    @Column(name = "cur_id", columnDefinition = "uuid")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cur_bol_id")
    private BoletimInformativoModel boletimInformativo;

    @Column(name = "cur_titulo")
    private String titulo;

    @Column(name = "cur_descricao")
    private String descricao;

    @Column(name = "cur_link")
    private String link;

    @Column(name = "cur_prazo_inscricao")
    private LocalDateTime prazoInscricao;

    @Column(name = "cur_preco")
    private Double preco;

    @Column(name = "cur_duracao_em_horas")
    private Integer duracaoEmHoras;

    @Column(name = "cur_data_cadastro")
    private Instant dataCadastro;

    @Column(name = "cur_data_atualizacao")
    private Instant dataAtualizacao;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "cursos_tags",
            joinColumns = @JoinColumn(name = "cur_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<TagModel> tags;

    public CursoModel() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BoletimInformativoModel getBoletimInformativo() {
        return boletimInformativo;
    }

    public void setBoletimInformativo(BoletimInformativoModel boletimInformativo) {
        this.boletimInformativo = boletimInformativo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public LocalDateTime getPrazoInscricao() {
        return prazoInscricao;
    }

    public void setPrazoInscricao(LocalDateTime prazoInscricao) {
        this.prazoInscricao = prazoInscricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getDuracaoEmHoras() {
        return duracaoEmHoras;
    }

    public void setDuracaoEmHoras(Integer duracaoEmHoras) {
        this.duracaoEmHoras = duracaoEmHoras;
    }

    public Instant getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Instant dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Instant getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Instant dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public List<TagModel> getTags() {
        return tags;
    }

    public void setTags(List<TagModel> tags) {
        this.tags = tags;
    }
}