INSERT INTO noticias (not_id, not_data_publicacao, not_data_atualizacao, not_data_cadastro, not_descricao, not_link,
                      not_titulo, not_bol_id)
VALUES ('39c38882-e2f2-4a52-bebd-09c75ff7a5f5',
        '2023-03-15',
        '2023-10-26',
        '2023-08-30',
        'As exportações de carne bovina fresca, refrigerada ou congelada finalizam em outubro/23 com 186,2 mil toneladas. De acordo com a Secretária de Comércio Exterior (Secex), o volume total registrou uma queda 1,17% frente ao total exportado em outubro do ano anterior, que ficou em 188,4 mil toneladas em 19 dias úteis',
        'https://www.noticiasagricolas.com.br/noticias/boi/362901-carne-bovina-volume-exportado-encerra-outubro-23-com-186-2-mil-toneladas.html',
        'Carne bovina: Volume exportado encerra outubro/23 com 186,2 mil toneladas',
        '451228f5-cb48-47b0-9a9a-d61629bd6a67'),
       ('1f94e305-98a7-4190-8df5-5891b679f24f',
        '2020-11-20',
        '2023-12-05',
        '2021-06-03',
        'A avicultura brasileira registra aumento na demanda interna e externa por carne de frango. A qualidade do produto e as estratégias de mercado têm impulsionado o setor.',
        'https://www.noticiasagricolas.com.br/noticias/aves/364784-avicultura-brasileira-registra-aumento-demanda-carne-frango.html',
        'Avicultura brasileira registra aumento na demanda por carne de frango',
        '63e81075-8e8f-4f91-bb94-7ff7f3f59945'),
       ('6b876f4d-1a2f-4a09-b9f5-21c9be83c6e1',
        '2022-11-10',
        '2023-12-30',
        '2023-11-15',
        'A produção de grãos tem previsão de aumento de 2,3% na safra de verão 2023/2024, com destaque para a soja e o milho. As estimativas indicam um cenário positivo para a agricultura brasileira.',
        'https://www.noticiasagricolas.com.br/noticias/agricultura/363214-producao-graos-tem-previsao-aumento-safra-verao-2023-2024.html',
        'Produção de grãos tem previsão de aumento na safra de verão 2023/2024',
        '63e81075-8e8f-4f91-bb94-7ff7f3f59945'),
       ('3b1d084a-6e0b-4187-8486-5f413a347470',
        '2021-12-01',
        '2023-11-12',
        '2022-01-25',
        'O mercado de carne suína registra aumento nas exportações para a Ásia. A China continua sendo o principal destino, impulsionando o setor e gerando expectativas positivas para os produtores.',
        'https://www.noticiasagricolas.com.br/noticias/suinos/363601-carne-suina-mercado-registra-aumento-exportacoes-para-asiaticos.html',
        'Carne suína: Mercado registra aumento nas exportações para asiáticos',
        'f68d478b-3f11-4564-aa29-907a43d6a4e2'),
       ('e6f04c5b-69e1-4eb5-b13b-3e631e13e960',
        '2023-02-18',
        '2023-11-20',
        '2023-02-20',
        'Os avanços na tecnologia de irrigação têm impactado positivamente a produtividade agrícola, especialmente em regiões áridas, contribuindo para a otimização do uso de recursos hídricos.',
        'https://www.noticiasagricolas.com.br/noticias/agricultura/364012-tecnologia-irrigacao-avanca-e-impacta-produtividade-agricola.html',
        'Tecnologia de irrigação avança e impacta produtividade agrícola',
        'eebae804-72a6-4f2b-a2aa-df0a5910bfe9'),
       ('598a2102-0d36-4f60-923e-846f31f145cb',
        '2023-11-28',
        '2023-12-15',
        '2023-11-30',
        'A produção de café apresenta aumento na safra atual, com a expectativa de uma colheita recorde. As condições climáticas favoráveis têm impulsionado o crescimento das lavouras.',
        'https://www.noticiasagricolas.com.br/noticias/cafe/364397-producao-cafe-apresenta-aumento-safra-atual.html',
        'Produção de café apresenta aumento na safra atual',
        'a235123e-0a94-4c67-b623-538fcd69c2bc');

INSERT INTO noticias_tags (not_id, tag_id)
VALUES ('1f94e305-98a7-4190-8df5-5891b679f24f', '3981b305-c46e-4782-9cbe-c40cfebbe885'),
       ('39c38882-e2f2-4a52-bebd-09c75ff7a5f5', '8e40c043-9359-4d01-98d1-3a95a36556d2'),
       ('598a2102-0d36-4f60-923e-846f31f145cb', 'f6d5345c-3b2e-4c88-8897-c2965db22c3a'),
       ('e6f04c5b-69e1-4eb5-b13b-3e631e13e960', '10de369d-42ae-4baf-bbad-224149c653ab'),
       ('3b1d084a-6e0b-4187-8486-5f413a347470', '8e40c043-9359-4d01-98d1-3a95a36556d2'),
       ('6b876f4d-1a2f-4a09-b9f5-21c9be83c6e1', 'f6d5345c-3b2e-4c88-8897-c2965db22c3a');
