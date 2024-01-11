package com.geppa.BoletinsInformativos.util.messages;

public enum MensagensRetorno {

        CONTEUDO_CRIADO_COM_SUCESSO("Conteúdo criado com sucesso"),
        CONTEUDO_ATUALIZADO_COM_SUCESSO("Conteúdo atualizado com sucesso"),
        CONTEUDO_EXCLUIDO_COM_SUCESSO("Conteúdo excluído com sucesso"),
        CONTEUDO_ENCONTRADO_COM_SUCESSO("Conteúdo encontrado com sucesso"),
        BUSCA_REALIZADA_COM_SUCESSO("Busca realizada com sucesso");

        private final String mensagem;

        MensagensRetorno(String mensagem) {
            this.mensagem = mensagem;
        }

        public String getMensagem() {
            return mensagem;
        }
}
