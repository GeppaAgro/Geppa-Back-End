package com.geppa.BoletinsInformativos.util.autoPreenchimentoAtributos;

import com.geppa.BoletinsInformativos.util.annotations.AutoPreenchimentoAtualizacao;
import com.geppa.BoletinsInformativos.util.annotations.AutoPreenchimentoCadastro;
import com.geppa.BoletinsInformativos.util.enums.TipoPreenchimento;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.time.Instant;

@Component
public class AutoPreenchimentoHelper {

    public void preencherAtributosComAnnotation(Object entity, Class<? extends Annotation> annotationType) {
        Class<?> currentClass = entity.getClass();
        while (currentClass!= null) {
            Field[] fields = currentClass.getDeclaredFields();
            for (Field field : fields) {
                Annotation annotation = field.getAnnotation(annotationType);
                if (annotation!= null) {
                    preencherAtributo(entity, field, annotationType, annotation);
                }
            }
            currentClass = currentClass.getSuperclass();
        }
    }

    private void preencherAtributo(Object entity, Field field, Class<? extends Annotation> annotationType, Annotation annotation) {
        field.setAccessible(true);
        try {
            if (annotationType == AutoPreenchimentoCadastro.class) {
                preencherCampo(entity, field, ((AutoPreenchimentoCadastro) annotation).value());
            } else if (annotationType == AutoPreenchimentoAtualizacao.class) {
                preencherCampo(entity, field, ((AutoPreenchimentoAtualizacao) annotation).value());
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Erro ao preencher campos");
        }
    }

    private void preencherCampo(Object entity, Field field, TipoPreenchimento tipo) throws IllegalAccessException {
        if (tipo == TipoPreenchimento.INSTANT && field.getType() == Instant.class) {
            field.set(entity, Instant.now());
        } else if (tipo == TipoPreenchimento.BOOLEAN && field.getType() == boolean.class) {
            boolean booleanValue;
            if (field.isAnnotationPresent(AutoPreenchimentoCadastro.class)) {
                booleanValue = field.getAnnotation(AutoPreenchimentoCadastro.class).booleanValue();
            } else {
                booleanValue = field.getAnnotation(AutoPreenchimentoAtualizacao.class).booleanValue();
            }
            field.set(entity, booleanValue);
        }
    }

}
