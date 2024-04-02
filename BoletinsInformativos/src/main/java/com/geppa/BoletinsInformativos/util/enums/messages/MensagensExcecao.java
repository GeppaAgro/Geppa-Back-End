package com.geppa.BoletinsInformativos.util.enums.messages;

public enum MensagensExcecao {

    CONTEUDO_NAO_ENCONTRADO_HASH("Conteúdo não encontrado para o hash: "),
    HASH_INVALIDA("Hash inválida: "),
    FALHA_CONVERSAO_MODELO_DOMINIO("Falha na conversão do modelo para domínio"),
    BOLETIM_NAO_ENCONTRADO_EDICAO("Boletim não encontrado para a edição: "),
    ORDENACAO_INVALIDA("Não foi possível ordenar por "),
    BUSCA_INVALIDA("Falha ao buscar os registros"),
    DADOS_NAO_ENCONTRADOS("Não foram encontrados registros com essas especificações para : "),
    REGISTRO_DUPLICADO("Registro já cadastrado"),
    FALHA_CADASTRO("Falha ao cadastrar o registro"),
    ERRO_VALIDACAO("Erro de validacao");

    private final String mensagem;

    MensagensExcecao(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
