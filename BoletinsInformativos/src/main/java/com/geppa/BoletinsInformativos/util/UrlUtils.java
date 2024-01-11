package com.geppa.BoletinsInformativos.util;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public abstract class UrlUtils {

    public static String obterUrl() {
        return ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
    }
}
