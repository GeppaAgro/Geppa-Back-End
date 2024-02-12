CREATE TABLE boletins_informativos
(
    bol_id               UUID PRIMARY KEY,
    bol_data_publicacao  DATE,
    bol_data_cadastro    TIMESTAMP(6),
    bol_data_atualizacao TIMESTAMP(6),
    bol_edicao           VARCHAR(15)
);

CREATE TABLE tags
(
    tag_id   UUID PRIMARY KEY,
    tag_nome VARCHAR(255)
);

CREATE TABLE artigos
(
    art_id               UUID PRIMARY KEY,
    art_data_publicacao  DATE,
    art_data_atualizacao TIMESTAMP(6),
    art_data_cadastro    TIMESTAMP(6),
    art_descricao        TEXT,
    art_link             VARCHAR(255),
    art_titulo           TEXT,
    art_bol_id           UUID,
    FOREIGN KEY (art_bol_id) REFERENCES boletins_informativos (bol_id)
);

CREATE TABLE artigos_tags
(
    art_id UUID NOT NULL,
    tag_id UUID NOT NULL,
    PRIMARY KEY (art_id, tag_id),
    FOREIGN KEY (art_id) REFERENCES artigos (art_id),
    FOREIGN KEY (tag_id) REFERENCES tags (tag_id)
);

CREATE TABLE autores
(
    aut_id     UUID PRIMARY KEY,
    aut_art_id UUID,
    aut_nome   VARCHAR(255),
    FOREIGN KEY (aut_art_id) REFERENCES artigos (art_id)
);

CREATE TABLE cursos
(
    cur_id               UUID PRIMARY KEY,
    cur_duracao_em_horas INTEGER,
    cur_preco            DOUBLE PRECISION,
    cur_data_atualizacao TIMESTAMP(6),
    cur_data_cadastro    TIMESTAMP(6),
    cur_prazo_inscricao  TIMESTAMP(6),
    cur_descricao        TEXT,
    cur_link             VARCHAR(255),
    cur_titulo           TEXT,
    cur_bol_id           UUID,
    FOREIGN KEY (cur_bol_id) REFERENCES boletins_informativos (bol_id)
);

CREATE TABLE cursos_tags
(
    cur_id UUID NOT NULL,
    tag_id UUID NOT NULL,
    PRIMARY KEY (cur_id, tag_id),
    FOREIGN KEY (cur_id) REFERENCES cursos (cur_id),
    FOREIGN KEY (tag_id) REFERENCES tags (tag_id)
);

CREATE TABLE eventos
(
    eve_id               UUID PRIMARY KEY,
    eve_preco            DOUBLE PRECISION,
    eve_data_atualizacao TIMESTAMP(6),
    eve_data_cadastro    TIMESTAMP(6),
    eve_data_hora_fim    TIMESTAMP(6),
    eve_data_hora_inicio TIMESTAMP(6),
    eve_descricao        TEXT,
    eve_link             VARCHAR(255),
    eve_titulo           TEXT,
    eve_local            VARCHAR(255),
    eve_bol_id           UUID,
    FOREIGN KEY (eve_bol_id) REFERENCES boletins_informativos (bol_id)
);

CREATE TABLE eventos_tags
(
    eve_id UUID NOT NULL,
    tag_id UUID NOT NULL,
    PRIMARY KEY (eve_id, tag_id),
    FOREIGN KEY (eve_id) REFERENCES eventos (eve_id),
    FOREIGN KEY (tag_id) REFERENCES tags (tag_id)
);

CREATE TABLE noticias
(
    not_id               UUID PRIMARY KEY,
    not_data_publicacao  DATE,
    not_data_atualizacao TIMESTAMP(6),
    not_data_cadastro    TIMESTAMP(6),
    not_descricao        TEXT,
    not_link             VARCHAR(255),
    not_titulo           TEXT,
    not_bol_id           UUID,
    FOREIGN KEY (not_bol_id) REFERENCES boletins_informativos (bol_id)
);

CREATE TABLE noticias_tags
(
    not_id UUID NOT NULL,
    tag_id UUID NOT NULL,
    PRIMARY KEY (not_id, tag_id),
    FOREIGN KEY (not_id) REFERENCES noticias (not_id),
    FOREIGN KEY (tag_id) REFERENCES tags (tag_id)
);

CREATE TABLE videos
(
    vid_id               UUID PRIMARY KEY,
    vid_data_atualizacao TIMESTAMP(6),
    vid_data_cadastro    TIMESTAMP(6),
    vid_descricao        TEXT,
    vid_link             VARCHAR(255),
    vid_titulo           TEXT,
    vid_youtube          BOOLEAN,
    vid_bol_id           UUID,
    FOREIGN KEY (vid_bol_id) REFERENCES boletins_informativos (bol_id)
);

CREATE TABLE videos_tags
(
    tag_id UUID NOT NULL,
    vid_id UUID NOT NULL,
    PRIMARY KEY (tag_id, vid_id),
    FOREIGN KEY (tag_id) REFERENCES tags (tag_id),
    FOREIGN KEY (vid_id) REFERENCES videos (vid_id)
);


CREATE TABLE indicadores
(
    ind_id     UUID PRIMARY KEY,
    ind_nome   VARCHAR(255),
    ind_valor  DOUBLE PRECISION,
    ind_unidade_medida VARCHAR(25),
    ind_data   DATE,
    ind_bol_id UUID,
    FOREIGN KEY (ind_bol_id) REFERENCES boletins_informativos (bol_id)
);
