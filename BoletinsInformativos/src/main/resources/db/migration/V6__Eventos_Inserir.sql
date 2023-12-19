INSERT INTO eventos (eve_id, eve_preco, eve_data_atualizacao, eve_data_cadastro, eve_data_hora_fim,
                     eve_data_hora_inicio, eve_descricao, eve_link, eve_titulo, eve_local, eve_bol_id)
VALUES ('596fa0d1-3250-40b3-b09b-6b77f77b4371', 49.99, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
        '2023-08-20 20:00:00', '2023-08-15 14:00:00',
        'Com mais de 147 expositores de diversos continentes que representa 250 marcas nacionais e internacionais, a EXPOMEAT é a principal e mais completa feira comercial realizada nos anos ímpares. 96% dos visitantes têm real perfil decisor de compra, dizem estar satisfeitos e que pretende visitar.',
        null, 'EXPOMEAT', 'Distrito Anhembi Av. Olavo Fontoura, 1209 - São Paulo - SP',
        '451228f5-cb48-47b0-9a9a-d61629bd6a67');

INSERT INTO eventos_tags (eve_id, tag_id)
VALUES ('596fa0d1-3250-40b3-b09b-6b77f77b4371', 'df53831b-044a-4721-ba79-f09bbdd5d935');
