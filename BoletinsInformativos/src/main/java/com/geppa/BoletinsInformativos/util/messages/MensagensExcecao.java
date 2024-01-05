package com.geppa.BoletinsInformativos.util.messages;

public enum MensagensExcecao {

    CONTEUDO_NAO_ENCONTRADO_HASH("Conteúdo não encontrado para o hash: "),
    HASH_INVALIDA("Hash inválida: "),
    FALHA_CONVERSAO_MODELO_DOMINIO("Falha na conversão do modelo para domínio"),
    BOLETIM_NAO_ENCONTRADO_EDICAO("Boletim não encontrado para a edição: ");

    private final String mensagem;

    MensagensExcecao(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
