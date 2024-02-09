package com.geppa.BoletinsInformativos.infrastructure.specifications;

import com.geppa.BoletinsInformativos.application.dtos.filters.FiltroGenericoDto;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class SpecificationFiltroGenerico<T> implements Specification<T> {

    private final FiltroGenericoDto filtroGenericoDto;

    public SpecificationFiltroGenerico(FiltroGenericoDto filtroGenericoDto) {
        this.filtroGenericoDto = filtroGenericoDto;
    }

    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = criteriaBuilder.conjunction();

        if (filtroGenericoDto.getDataMinima() != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get("dataCadastro"), filtroGenericoDto.getDataMinima()));
        }

        if (filtroGenericoDto.getDataMaxima() != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThanOrEqualTo(root.get("dataCadastro"), filtroGenericoDto.getDataMaxima()));
        }

        if (filtroGenericoDto.getTags() != null && !filtroGenericoDto.getTags().isEmpty()) {
            predicate = criteriaBuilder.and(predicate, root.join("tags").get("nome").in(filtroGenericoDto.getTags()));
        }

        return predicate;
    }
}
