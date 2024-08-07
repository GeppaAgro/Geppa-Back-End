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
        TAG_ATUALIZADA_COM_SUCESSO("Tag atualizada com sucesso");

        private final String mensagem;

        MensagensRetorno(String mensagem) {
            this.mensagem = mensagem;
        }

        public String getMensagem() {
            return mensagem;
        }
}
