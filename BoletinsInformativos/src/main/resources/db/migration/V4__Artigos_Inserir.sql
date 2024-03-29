INSERT INTO conteudos (con_id, con_data_atualizacao, con_data_cadastro, con_descricao, con_link, con_titulo, con_bol_id)
VALUES ('dbbdd55c-8efb-4491-929a-60b5b876e97b',
        '2021-07-15',
        '2021-07-15',
        'O fenômeno natural da heterose ou vigor híbrido mostrou, de acordo com a pesquisa, que quanto maior é a distância genética entre as raças, melhor é a qualidade dos animais obtidos em cruzamentos. Já os animais com muita proximidade sanguínea têm desempenho inferior em relação ao peso da carcaça, produção de leite, resistência às doenças e às adversidades do meio ambiente',
        'https://www.embrapa.br/busca-de-noticias/-/noticia/21238707/distancia-genetica-ajuda-a-incrementar-producao-animal',
        'Distância genética ajuda a incrementar produção animal',
        '451228f5-cb48-47b0-9a9a-d61629bd6a67'),
       ('fcc1e673-1e52-4b58-9dc4-d6ae12d7c2e5',
        '2022-03-29',
        '2022-03-29',
        'Estudo revela a importância da rotação de culturas na melhoria da saúde do solo e no aumento da produtividade agrícola. A prática também contribui para a redução do uso de agroquímicos.',
        'https://www.agricultura-sustentavel.com.br/estudo-rotacao-culturas',
        'Importância da Rotação de Culturas na Agricultura Sustentável',
        '63e81075-8e8f-4f91-bb94-7ff7f3f59945'),
       ('dc171c55-6606-4320-a761-174e48e6d0a2',
        '2023-10-11',
        '2023-10-11',
        'Novas técnicas de manejo de pastagens melhoram a produtividade e a qualidade nutricional para o gado de corte. O artigo destaca estratégias de adubação e rotação de pastagens.',
        'https://www.agropecuaria-produtiva.com.br/novas-tecnicas-manejo-pastagens',
        'Técnicas de Manejo de Pastagens para Gado de Corte',
        'f68d478b-3f11-4564-aa29-907a43d6a4e2'),
       ('5f456c08-9a60-4c38-b02e-1c485af70ba5',
        '2023-11-02',
        '2023-11-02',
        'Estudo demonstra os benefícios econômicos e ambientais da adoção de práticas agroflorestais em propriedades rurais. A integração de árvores às áreas produtivas promove a diversificação e a conservação dos recursos naturais.',
        'https://www.agrofloresta-sustentavel.com.br/estudo-praticas-agroflorestais',
        'Benefícios das Práticas Agroflorestais em Propriedades Rurais',
        'a235123e-0a94-4c67-b623-538fcd69c2bc'),
       ('f3f9984f-3f8c-432e-9b2b-3b101ef82c64',
        '2024-01-09',
        '2024-01-09',
        'Pesquisa avalia os impactos das mudanças climáticas na produção de grãos no Brasil. Modelos indicam redução na safra devido ao aumento da temperatura e alterações nos regimes de chuva.',
        'https://www.mudancas-climaticas-agricultura.com.br/impactos-mudancas-climaticas-producao-graos',
        'Impactos das Mudanças Climáticas na Produção de Grãos no Brasil',
        'a235123e-0a94-4c67-b623-538fcd69c2bc'),
       ('e6b91dbd-7572-42cc-a8af-238b318ce7b0',
        '2024-02-05',
        '2024-02-05',
        'Artigo discute o uso de drones na agricultura para monitoramento de lavouras. A tecnologia tem auxiliado na detecção precoce de doenças e na aplicação precisa de insumos.',
        'https://www.drones-agricultura.com.br/usos-drones-monitoramento-lavouras',
        'Uso de Drones na Agricultura para Monitoramento de Lavouras',
        '451228f5-cb48-47b0-9a9a-d61629bd6a67');

INSERT INTO artigos (con_id, art_data_publicacao)
VALUES ('dbbdd55c-8efb-4491-929a-60b5b876e97b', '2021-07-15'),
       ('fcc1e673-1e52-4b58-9dc4-d6ae12d7c2e5', '2022-03-29'),
       ('dc171c55-6606-4320-a761-174e48e6d0a2', '2023-10-11'),
       ('5f456c08-9a60-4c38-b02e-1c485af70ba5', '2023-11-02'),
       ('f3f9984f-3f8c-432e-9b2b-3b101ef82c64', '2024-01-09'),
       ('e6b91dbd-7572-42cc-a8af-238b318ce7b0', '2024-02-05');

INSERT INTO con_tags (con_id, tag_id)
VALUES ('e6b91dbd-7572-42cc-a8af-238b318ce7b0', '3981b305-c46e-4782-9cbe-c40cfebbe885'),
       ('e6b91dbd-7572-42cc-a8af-238b318ce7b0', 'df53831b-044a-4721-ba79-f09bbdd5d935'),
       ('dbbdd55c-8efb-4491-929a-60b5b876e97b', '3981b305-c46e-4782-9cbe-c40cfebbe885'),
       ('dbbdd55c-8efb-4491-929a-60b5b876e97b', '10de369d-42ae-4baf-bbad-224149c653ab'),
       ('fcc1e673-1e52-4b58-9dc4-d6ae12d7c2e5', 'f6d5345c-3b2e-4c88-8897-c2965db22c3a'),
       ('fcc1e673-1e52-4b58-9dc4-d6ae12d7c2e5', '10de369d-42ae-4baf-bbad-224149c653ab'),
       ('dc171c55-6606-4320-a761-174e48e6d0a2', 'f6d5345c-3b2e-4c88-8897-c2965db22c3a'),
       ('dc171c55-6606-4320-a761-174e48e6d0a2', '3981b305-c46e-4782-9cbe-c40cfebbe885'),
       ('5f456c08-9a60-4c38-b02e-1c485af70ba5', 'f6d5345c-3b2e-4c88-8897-c2965db22c3a'),
       ('5f456c08-9a60-4c38-b02e-1c485af70ba5', 'df53831b-044a-4721-ba79-f09bbdd5d935'),
       ('f3f9984f-3f8c-432e-9b2b-3b101ef82c64', 'f6d5345c-3b2e-4c88-8897-c2965db22c3a'),
       ('f3f9984f-3f8c-432e-9b2b-3b101ef82c64', '10de369d-42ae-4baf-bbad-224149c653ab');

INSERT INTO autores (aut_id, aut_art_id, aut_nome)
VALUES ('55232ea6-47a7-467d-beb9-83c9d687efaa', 'dbbdd55c-8efb-4491-929a-60b5b876e97b', 'Fernando Sinimbu'),
       ('b23d06c6-bd38-4768-8174-740c136e1a3a', 'fcc1e673-1e52-4b58-9dc4-d6ae12d7c2e5', 'Ana Silva'),
       ('42ab9b94-468b-4631-bf45-45849c319628', 'dc171c55-6606-4320-a761-174e48e6d0a2', 'Rafael Mendes'),
       ('c8edfe6a-2a0f-47a1-9761-9c2a6b1b55b4', '5f456c08-9a60-4c38-b02e-1c485af70ba5', 'João Carlos'),
       ('7f261534-4c12-4bb3-b709-99bb5d0ee811', '5f456c08-9a60-4c38-b02e-1c485af70ba5', 'Lucas Silva'),
       ('0fb3929a-90f0-412f-bbbe-3ac9ed4f3df7', 'f3f9984f-3f8c-432e-9b2b-3b101ef82c64', 'Carolina Almeida'),
       ('abf19d51-9f47-46af-b51b-f562c71269ff', 'e6b91dbd-7572-42cc-a8af-238b318ce7b0', 'Pedro Rodrigues'),
       ('203bf4df-70c5-436f-9dca-a63d69fa2623', 'e6b91dbd-7572-42cc-a8af-238b318ce7b0', 'Rafael Mendes');