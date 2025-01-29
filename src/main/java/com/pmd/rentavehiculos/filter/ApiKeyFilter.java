package com.pmd.rentavehiculos.filter;

import com.pmd.rentavehiculos.service.UsuarioService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
public class ApiKeyFilter implements Filter {

    private final UsuarioService usuarioService;

    public ApiKeyFilter(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var req = (HttpServletRequest) servletRequest;

        if (req.getServletPath().startsWith("/vehiculos")) {
            Optional.ofNullable(req.getHeader("x-llave-api"))
                    .filter(usuarioService::verificacionLlave)
                    .orElseThrow(() -> new RuntimeException("la llave no es valida"));
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

}
