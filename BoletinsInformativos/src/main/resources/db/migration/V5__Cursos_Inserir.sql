INSERT INTO cursos (cur_id, cur_duracao_em_horas, cur_preco, cur_data_atualizacao, cur_data_cadastro,
                    cur_prazo_inscricao, cur_descricao, cur_link, cur_titulo, cur_bol_id)
VALUES ('2700b904-4282-44be-ad2e-15e24589ac1c', 40, 199.99, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, null,
        'A criação de galinhas caipiras pode ser feita com o uso de recursos renováveis, em locais de pequena infraestrutura. Sendo um animal capaz de suportar adversidades climáticas e resistir a doenças.',
        'https://www.abbacursos.com.br/curso-de-criacao-de-galinha-caipira', ' Criação de Galinhas Caipiras.',
        '451228f5-cb48-47b0-9a9a-d61629bd6a67');

INSERT INTO cursos_tags (cur_id, tag_id)
VALUES ('2700b904-4282-44be-ad2e-15e24589ac1c', '8e40c043-9359-4d01-98d1-3a95a36556d2'),
       ('2700b904-4282-44be-ad2e-15e24589ac1c', 'df53831b-044a-4721-ba79-f09bbdd5d935');
