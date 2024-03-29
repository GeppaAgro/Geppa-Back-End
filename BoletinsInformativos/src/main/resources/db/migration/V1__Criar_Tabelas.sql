-- Tabela Boletins Informativos
CREATE TABLE boletins_informativos
(
    bol_data_publicacao  DATE,
    bol_data_atualizacao TIMESTAMP(6) WITH TIME ZONE,
    bol_data_cadastro    TIMESTAMP(6) WITH TIME ZONE,
    bol_id               UUID NOT NULL,
    bol_edicao           VARCHAR(255),
    CONSTRAINT pk_boletins_informativos PRIMARY KEY (bol_id)
);

-- Tabela Conteúdos
CREATE TABLE conteudos
(
    con_data_atualizacao TIMESTAMP(6) WITH TIME ZONE,
    con_data_cadastro    TIMESTAMP(6) WITH TIME ZONE,
    con_bol_id           UUID,
    con_id               UUID NOT NULL,
    con_descricao        TEXT,
    con_link             VARCHAR(255),
    con_titulo           VARCHAR(255),
    CONSTRAINT pk_conteudos PRIMARY KEY (con_id),
    CONSTRAINT fk_conteudos_boletins_informativos FOREIGN KEY (con_bol_id) REFERENCES boletins_informativos (bol_id)
);

-- Tabela Tags
CREATE TABLE tags
(
    tag_id   UUID NOT NULL,
    tag_nome VARCHAR(255),
    CONSTRAINT pk_tags PRIMARY KEY (tag_id)
);

-- Tabela Conteúdo-Tag
CREATE TABLE con_tags
(
    con_id UUID NOT NULL,
    tag_id UUID NOT NULL,
    CONSTRAINT fk_con_tags_conteudos FOREIGN KEY (con_id) REFERENCES conteudos (con_id),
    CONSTRAINT fk_con_tags_tags FOREIGN KEY (tag_id) REFERENCES tags (tag_id)
);

-- Tabela Artigos
CREATE TABLE artigos
(
    art_data_publicacao DATE,
    con_id              UUID NOT NULL,
    CONSTRAINT pk_artigos PRIMARY KEY (con_id),
    CONSTRAINT fk_artigos_conteudos FOREIGN KEY (con_id) REFERENCES conteudos (con_id)
);

-- Tabela Autores
CREATE TABLE autores
(
    aut_art_id UUID,
    aut_id     UUID NOT NULL,
    aut_nome   VARCHAR(255),
    CONSTRAINT pk_autores PRIMARY KEY (aut_id),
    CONSTRAINT fk_autores_artigos FOREIGN KEY (aut_art_id) REFERENCES artigos (con_id)
);

-- Tabela Cursos
CREATE TABLE cursos
(
    cur_duracao_em_horas INTEGER,
    cur_preco            DOUBLE PRECISION,
    cur_prazo_inscricao  TIMESTAMP(6),
    con_id               UUID NOT NULL,
    CONSTRAINT pk_cursos PRIMARY KEY (con_id),
    CONSTRAINT fk_cursos_conteudos FOREIGN KEY (con_id) REFERENCES conteudos (con_id)
);

-- Tabela Eventos
CREATE TABLE eventos
(
    eve_preco            DOUBLE PRECISION,
    eve_data_hora_fim    TIMESTAMP(6),
    eve_data_hora_inicio TIMESTAMP(6),
    con_id               UUID NOT NULL,
    eve_local            VARCHAR(255),
    CONSTRAINT pk_eventos PRIMARY KEY (con_id),
    CONSTRAINT fk_eventos_conteudos FOREIGN KEY (con_id) REFERENCES conteudos (con_id)
);

-- Tabela Notícias
CREATE TABLE noticias
(
    not_data_publicacao DATE,
    con_id              UUID NOT NULL,
    CONSTRAINT pk_noticias PRIMARY KEY (con_id),
    CONSTRAINT fk_noticias_conteudos FOREIGN KEY (con_id) REFERENCES conteudos (con_id)
);

-- Tabela videos
CREATE TABLE videos
(
    vid_youtube bool,
    con_id  UUID NOT NULL,
    CONSTRAINT pk_videos PRIMARY KEY (con_id),
    CONSTRAINT fk_videos_conteudos FOREIGN KEY (con_id) REFERENCES conteudos (con_id)
);

-- Tabela Indicadores
CREATE TABLE indicadores
(
    ind_data           DATE,
    ind_valor          DOUBLE PRECISION,
    ind_bol_id         UUID,
    ind_id             UUID NOT NULL,
    ind_nome           VARCHAR(255),
    ind_unidade_medida VARCHAR(255),
    CONSTRAINT pk_indicadores PRIMARY KEY (ind_id),
    CONSTRAINT fk_indicadores_boletins_informativos FOREIGN KEY (ind_bol_id) REFERENCES boletins_informativos (bol_id)
);

-- Tabela Inscrição Newsletter
CREATE TABLE inscricao_newsletter
(
    inl_ativo            BOOLEAN,
    inl_data_atualizacao TIMESTAMP(6) WITH TIME ZONE,
    inl_data_cadastro    TIMESTAMP(6) WITH TIME ZONE,
    inl_id               UUID NOT NULL,
    inl_email            VARCHAR(255),
    CONSTRAINT pk_inscricao_newsletter PRIMARY KEY (inl_id)
);