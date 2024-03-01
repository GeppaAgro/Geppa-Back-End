package com.geppa.BoletinsInformativos.infrastructure.gateways;

import com.geppa.BoletinsInformativos.infrastructure.persistencia.RepositorioGenerico;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class GatewayRepositoryGenericoFactory {

    private final BeanFactory beanFactory;
    private final HashMap<Class<?>, GatewayGenericoRepositorio<?>> repositoryMap = new HashMap<>();

    @Autowired
    public GatewayRepositoryGenericoFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public <T> GatewayGenericoRepositorio<T> getGatewayFor(Class<T> classeDominio) {
        return (GatewayGenericoRepositorio<T>) repositoryMap.computeIfAbsent(classeDominio, this::createGateway);
    }

    private <T> GatewayGenericoRepositorio<T> createGateway(Class<T> classeDominio) {
        String repositoryBeanName = Character.toLowerCase(classeDominio.getSimpleName().charAt(0)) + classeDominio.getSimpleName().substring(1) + "Repositorio";
        RepositorioGenerico repository = beanFactory.getBean(repositoryBeanName, RepositorioGenerico.class);
        if (repository == null) {
            throw new RuntimeException("Nenhum bean de repositório encontrado para a classe: " + classeDominio.getSimpleName());
        }
        return new GatewayGenericoRepositorio<>(repository, classeDominio);
    }
}