package com.pmd.rentavehiculos.filter;

import com.pmd.rentavehiculos.service.UsuarioService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

@Component
public class ApiKeyFilter implements Filter {

    private final Predicate<String> servlets = (servletPath) ->
        servletPath.startsWith("/vehiculos") || servletPath.startsWith("/personas");
    private final UsuarioService usuarioService;

    public ApiKeyFilter(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var req = (HttpServletRequest) servletRequest;

        if (servlets.test(req.getServletPath())) {
            Optional.ofNullable(req.getHeader("x-llave-api"))
                    .filter(usuarioService::verificacionLlave)
                    .orElseThrow(() -> new RuntimeException("la llave no es valida"));
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

}
