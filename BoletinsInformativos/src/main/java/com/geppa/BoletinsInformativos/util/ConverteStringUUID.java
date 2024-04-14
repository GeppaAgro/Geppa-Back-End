package com.geppa.BoletinsInformativos.util;

import com.geppa.BoletinsInformativos.domain.exceptions.HashInvalidaExcecao;

import java.util.UUID;

public abstract class ConverteStringUUID {

    public static UUID converter(String hash) {
        try {
        return UUID.fromString(hash);
        } catch (Exception e) {
        throw new HashInvalidaExcecao(hash);
        }
    }

    public static String converter(UUID uuid) {
        return uuid.toString();
    }
}
