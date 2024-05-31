package com.geppa.BoletinsInformativos.util.enums.messages;

public enum MensagensRetorno {

        CONTEUDO_CRIADO_COM_SUCESSO("Conteúdo criado com sucesso"),
        CONTEUDO_ATUALIZADO_COM_SUCESSO("Conteúdo atualizado com sucesso"),
        CONTEUDO_EXCLUIDO_COM_SUCESSO("Conteúdo excluído com sucesso"),
        CONTEUDO_ENCONTRADO_COM_SUCESSO("Conteúdo encontrado com sucesso"),
        BUSCA_REALIZADA_COM_SUCESSO("Busca realizada com sucesso"),
        SUCESSO_INSCRICAO_NEWSLETTER("Inscrição realizada com sucesso"),
        ULTIMOS_CONTEUDOS_ENCONTRADOS_COM_SUCESSO("Últimos conteúdos encontrados com sucesso"),
        SUCESSO_CANCELAMENTO_NEWSLETTER("Cancelamento de inscrição realizado com sucesso"),
        TAG_CADASTRADA_SUCESSO("Tag cadastrada com sucesso"),
        TAG_DELETADA_COM_SUCESSO("Tag deletada com sucesso"),
        TAG_ATUALIZADA_COM_SUCESSO("Tag atualizada com sucesso"),
        CONTEUDO_VALIDADO_COM_SUCESSO("Conteúdo validado com sucesso"),
        INDICADOR_VALIDADO_COM_SUCESSO("Indicador validado com sucesso"),
        BOLETIM_CADASTRADO_COM_SUCESSO("Boletim Informativo cadastrado com successo"),
        SUCESSO_ENVIO_EMAILS("E-mails enviados com sucesso"),
        BOLETIM_DELETADO_COM_SUCESSO("Boletim deletado com sucesso"),
        AUTEHTICACAO_SUCESSO("Autenticacao realizada com sucesso"),
        REFRESH_TOKEN_SUCESSO("Refresh token realizado com sucesso");

        private final String mensagem;

        MensagensRetorno(String mensagem) {
            this.mensagem = mensagem;
        }

        public String getMensagem() {
            return mensagem;
        }
}
