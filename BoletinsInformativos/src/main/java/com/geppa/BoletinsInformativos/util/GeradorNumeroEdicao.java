package com.geppa.BoletinsInformativos.util;

import java.time.LocalDate;
import java.util.Random;
public abstract class GeradorNumeroEdicao {

    public static String gerarNumeroEdicao() {
        LocalDate hoje = LocalDate.now();

        int dia = hoje.getDayOfMonth();
        int mes = hoje.getMonthValue();
        int ano = hoje.getYear();

        Random random = new Random();
        char letraAleatoria = (char) ('A' + random.nextInt(26));

        return String.format("%02d%02d%d%c", dia, mes, ano % 100, letraAleatoria);
    }
}


