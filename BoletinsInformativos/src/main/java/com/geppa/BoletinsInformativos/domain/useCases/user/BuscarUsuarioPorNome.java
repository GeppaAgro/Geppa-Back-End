package com.geppa.BoletinsInformativos.domain.useCases.user;

import com.geppa.BoletinsInformativos.domain.classes.security.User;
import com.geppa.BoletinsInformativos.domain.exceptions.UsuarioNaoEncontradoException;
import com.geppa.BoletinsInformativos.infrastructure.gateways.GatewayUserRepositorio;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BuscarUsuarioPorNome implements UserDetailsService {

    private final GatewayUserRepositorio repository;

    public BuscarUsuarioPorNome(GatewayUserRepositorio repository) {
        this.repository = repository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repository.findByUserName(username);
        if (user != null) {
            return user;
        } else {
            throw new UsuarioNaoEncontradoException();
        }
    }
}
