package com.geppa.BoletinsInformativos.application.dtos.security;

public class AccountCredentialsDto {
    private final String username;
    private final String password;

    public AccountCredentialsDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}