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
    ERRO_VALIDACAO("Erro de validacao"),
    INSCRICAO_NAO_ENCONTRADA("Inscrição não encontrada Para o email: "),
    INSCRICAO_JA_CANCELADA("Inscrição já cancelada Para o email: "),
    TAG_EM_USO("A tag está sendo utilizada, não é possível excluí-la. Quantidade de conteúdos: "),
    TAG_NAO_ENCONTRADA("Tag não encontrada"),
    NOME_TAG_INVALIDO("Nome da tag fornecida é inválido. Ele não deve ser vazio ou conter caracteres especiais"),
    REGISTRO_NAO_ENCONTRADO("Registro não encontrado");

    private final String mensagem;

    MensagensExcecao(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
