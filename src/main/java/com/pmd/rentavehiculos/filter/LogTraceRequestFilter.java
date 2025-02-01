package com.pmd.rentavehiculos.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class LogTraceRequestFilter implements Filter {

    private Logger log = Logger.getLogger(LogTraceRequestFilter.class.getName());

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        long startTime = System.currentTimeMillis();
        String reqUrlWithQuery = req.getRequestURI().concat(null != req.getQueryString() ? "?".concat(req.getQueryString()) : "");
        log.log(Level.INFO, String.format("Request %6s %s", req.getMethod(), reqUrlWithQuery));

        filterChain.doFilter(servletRequest, servletResponse);

        startTime = System.currentTimeMillis() - startTime;
        log.log(Level.INFO,
                String.format("Response %d in %02d:%02d.%03d", res.getStatus(),
                        TimeUnit.MILLISECONDS.toMinutes(startTime),
                        TimeUnit.MILLISECONDS.toSeconds(startTime) % 60,
                        TimeUnit.MILLISECONDS.toMillis(startTime) % 100));
    }

}
