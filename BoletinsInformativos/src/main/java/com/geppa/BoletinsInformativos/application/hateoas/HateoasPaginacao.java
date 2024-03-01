package com.geppa.BoletinsInformativos.application.hateoas;

import com.geppa.BoletinsInformativos.application.dtos.padrao.RetornoPadraoComPaginacaoDto;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.Link;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class HateoasPaginacao {

    public static final String PRIMEIRA_PAGINA = "primeiraPagina";
    public static final String PAGINA_ANTERIOR = "paginaAnterior";
    public static final String PROXIMA_PAGINA = "proximaPagina";
    public static final String ULTIMA_PAGINA = "ultimaPagina";

    public static void addHateoas(RetornoPadraoComPaginacaoDto retorno, Page<?> page) {
        String url = retorno.getPath();
        int paginaAtual = page.getNumber();
        int tamanhoPagina = page.getSize();
        int totalPaginas = page.getTotalPages();

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
                .replaceQueryParam("page", "{page}")
                .replaceQueryParam("size", "{size}");

        if (page.getSort().isSorted()) {
            page.getSort().forEach(order -> {
                String sortParam = order.getProperty() + "," + order.getDirection();
                uriBuilder.queryParam("sort", sortParam);
            });
        }

        URI primeiraPagina = uriBuilder.cloneBuilder()
                .build(0, tamanhoPagina);
        retorno.add(Link.of(primeiraPagina.toString()).withRel(PRIMEIRA_PAGINA));

        if (paginaAtual > 0) {
            URI paginaAnterior = uriBuilder.cloneBuilder()
                    .build(paginaAtual - 1, tamanhoPagina);
            retorno.add(Link.of(paginaAnterior.toString()).withRel(PAGINA_ANTERIOR));
        }

        if (paginaAtual < totalPaginas - 1) {
            URI proximaPagina = uriBuilder.cloneBuilder()
                    .build(paginaAtual + 1, tamanhoPagina);
            retorno.add(Link.of(proximaPagina.toString()).withRel(PROXIMA_PAGINA));
        }

        URI ultimaPagina = uriBuilder.cloneBuilder()
                .build(totalPaginas - 1, tamanhoPagina);
        retorno.add(Link.of(ultimaPagina.toString()).withRel(ULTIMA_PAGINA));
    }
}
