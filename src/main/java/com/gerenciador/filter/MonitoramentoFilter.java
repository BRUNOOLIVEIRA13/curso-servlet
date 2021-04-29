package com.gerenciador.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebFilter(filterName = "MonitoramentoFilter", urlPatterns = "/browse")
public class MonitoramentoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        long antes = System.currentTimeMillis();

        String paramAction = request.getParameter("action");

        // Executa a ação, é tipo o motoboy do RequestDispatcher.foward(), que pendura as requisições e respostas
        chain.doFilter(request, response);

        long depois = System.currentTimeMillis();
        System.out.println("Tempo de execução da ação: " + paramAction + " é de : " + (depois - antes));

    }
}
