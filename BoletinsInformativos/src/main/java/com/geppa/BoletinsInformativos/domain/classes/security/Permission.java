package com.geppa.BoletinsInformativos.domain.classes.security;

import org.springframework.security.core.GrantedAuthority;


public class Permission implements GrantedAuthority {

    private Long id;

    private String description;

    public Permission() {
    }

    @Override
    public String getAuthority() {
        return this.description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}