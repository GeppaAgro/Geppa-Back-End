package com.geppa.BoletinsInformativos.util.mapper;

import org.modelmapper.ModelMapper;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mapper {
    private static final ModelMapper modelMapper = new ModelMapper();
    private static final Map<Class<?>, Class<?>> mappingConfig = new HashMap<>();

    static {
        mappingConfig.putAll(MappingConfig.MAPPING_DOMAIN_MODEL);
        MappingConfig.MAPPING_DOMAIN_MODEL.forEach((key, value) -> mappingConfig.put(value, key));
        mappingConfig.putAll(MappingConfig.MAPPING_DOMAIN_DTO);
        MappingConfig.MAPPING_DOMAIN_DTO.forEach((key, value) -> mappingConfig.put(value, key));
    }

    public static <O, D> D parseObject(O origin, Class<D> destination) {
        if (Modifier.isAbstract(destination.getModifiers())) {
            Class<?> destinationClass = mappingConfig.get(origin.getClass());
            if (destinationClass == null) {
                throw new IllegalArgumentException("No mapping found for abstract destination class: " + destination.getName());
            }
            return (D) modelMapper.map(origin, destinationClass);
        } else {
            return (D) modelMapper.map(origin, destination);
        }
    }

    public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
        List<D> destinationObjects = new ArrayList<D>();
        origin.forEach(o -> destinationObjects.add(Mapper.parseObject(o, destination)));
        return destinationObjects;
    }
}
