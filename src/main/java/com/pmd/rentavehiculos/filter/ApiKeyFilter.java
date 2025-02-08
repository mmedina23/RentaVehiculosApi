package com.pmd.rentavehiculos.filter;

import com.pmd.rentavehiculos.service.UsuarioService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;
import java.util.function.Predicate;

@Component
public class ApiKeyFilter implements Filter {

    private final String errorDto = "{\"mensaje\": \"La llave no es valida\"}";
    private final Predicate<String> servlets = servletPath ->
            servletPath.startsWith("/vehiculos") || servletPath.startsWith("/personas");
    private final UsuarioService usuarioService;

    public ApiKeyFilter(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var req = (HttpServletRequest) servletRequest;
        boolean isValid = Boolean.TRUE;

        if (servlets.test(req.getServletPath())) {
            isValid = Optional.ofNullable(req.getHeader("x-llave-api"))
                    .filter(usuarioService::verificacionLlave)
                    .isPresent();
        }

        if (isValid)
            filterChain.doFilter(servletRequest, servletResponse);
        else {
            var res = (HttpServletResponse) servletResponse;
            res.setStatus(HttpServletResponse.SC_FORBIDDEN);
            res.addHeader("content-type", "application/json");
            res.getWriter().write(errorDto);
            res.getWriter().flush();
        }

    }

}
