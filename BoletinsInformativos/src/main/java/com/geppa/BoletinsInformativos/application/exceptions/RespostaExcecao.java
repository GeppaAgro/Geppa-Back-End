package com.geppa.BoletinsInformativos.application.exceptions;

public record RespostaExcecao(String dataHora, int status, String mensagem, String path) {
}