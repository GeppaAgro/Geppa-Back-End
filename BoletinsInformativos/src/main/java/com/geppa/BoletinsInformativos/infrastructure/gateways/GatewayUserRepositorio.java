package com.geppa.BoletinsInformativos.infrastructure.gateways;


import com.geppa.BoletinsInformativos.domain.classes.security.User;
import com.geppa.BoletinsInformativos.infrastructure.persistencia.UserRepositorio;
import com.geppa.BoletinsInformativos.util.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GatewayUserRepositorio {

    @Autowired
    private final UserRepositorio repository;

    public GatewayUserRepositorio(UserRepositorio repository) {
        this.repository = repository;
    }

    public User findByUserName(String userName) {
        return Mapper.parseObject(repository.findByUserName(userName), User.class);
    }
}
