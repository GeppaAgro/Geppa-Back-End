INSERT INTO artigos (art_id, art_data_publicacao, art_data_atualizacao, art_data_cadastro, art_descricao, art_link,
                    art_titulo, art_bol_id)
VALUES ('dbbdd55c-8efb-4491-929a-60b5b876e97b', '2023-01-05', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
        'O fenômeno natural da heterose ou vigor híbrido mostrou, de acordo com a pesquisa, que quanto maior é a distância genética entre as raças, melhor é a qualidade dos animais obtidos em cruzamentos. Já os animais com muita proximidade sanguínea têm desempenho inferior em relação ao peso da carcaça, produção de leite, resistência às doenças e às adversidades do meio ambiente',
        'https://www.embrapa.br/busca-de-noticias/-/noticia/21238707/distancia-genetica-ajuda-a-incrementar-producao-animal',
        'Distância genética ajuda a incrementar produção animal', '451228f5-cb48-47b0-9a9a-d61629bd6a67');

INSERT INTO artigos_tags (art_id, tag_id)
VALUES ('dbbdd55c-8efb-4491-929a-60b5b876e97b', '3981b305-c46e-4782-9cbe-c40cfebbe885'),
       ('dbbdd55c-8efb-4491-929a-60b5b876e97b', '10de369d-42ae-4baf-bbad-224149c653ab');

INSERT INTO autores (aut_id, aut_art_id, aut_nome)
VALUES ('55232ea6-47a7-467d-beb9-83c9d687efaa', 'dbbdd55c-8efb-4491-929a-60b5b876e97b', 'Fernando Sinimbu');