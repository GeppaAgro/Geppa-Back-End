INSERT INTO videos (vid_id, vid_data_atualizacao, vid_data_cadastro, vid_descricao, vid_link, vid_titulo, vid_youtube,
                    vid_bol_id)
VALUES ('e8398cf0-57e8-4e1d-bc5b-13ff40f1c849', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
        'Práticas de Plantio Direto na Agricultura Moderna', 'https://www.agronegocio.com/plantio-direto-agricultura',
        'Plantio Direto na Agricultura', false, '451228f5-cb48-47b0-9a9a-d61629bd6a67');

INSERT INTO videos_tags (vid_id, tag_id)
VALUES ('e8398cf0-57e8-4e1d-bc5b-13ff40f1c849', 'f6d5345c-3b2e-4c88-8897-c2965db22c3a');
