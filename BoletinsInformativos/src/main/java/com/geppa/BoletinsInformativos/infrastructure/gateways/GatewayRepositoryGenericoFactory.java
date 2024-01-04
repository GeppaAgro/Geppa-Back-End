package com.geppa.BoletinsInformativos.infrastructure.gateways;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
public class GatewayRepositoryGenericoFactory {

    private final BeanFactory beanFactory;
    private final ConcurrentMap<Class<?>, GatewayGenericoRepositorio<?>> repositoryMap = new ConcurrentHashMap<>();

    @Autowired
    public GatewayRepositoryGenericoFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public <T> GatewayGenericoRepositorio<T> getGatewayFor(Class<T> classeDominio) {
        return (GatewayGenericoRepositorio<T>) repositoryMap.computeIfAbsent(classeDominio, this::createGateway);
    }

    private <T> GatewayGenericoRepositorio<T> createGateway(Class<T> classeDominio) {
        String repositoryBeanName = Character.toLowerCase(classeDominio.getSimpleName().charAt(0)) + classeDominio.getSimpleName().substring(1) + "Repositorio";
        JpaRepository<T, UUID> repository = beanFactory.getBean(repositoryBeanName, JpaRepository.class);
        if (repository == null) {
            throw new RuntimeException("Nenhum bean de repositório encontrado para a classe: " + classeDominio.getSimpleName());
        }
        return new GatewayGenericoRepositorio<>(repository, classeDominio);
    }
}