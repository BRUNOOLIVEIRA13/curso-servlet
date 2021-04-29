package com.gerenciador.controller;

import com.gerenciador.action.Acao;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(filterName = "ControllerFilter", urlPatterns = "/browse")
public class ControllerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {

        //Precisa ser feito um cast, pois o filter é um tipo mais generics de servlet e precisa ser HttpServlet (mais especifica);
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String paramAction = request.getParameter("action");
        String nomeDaClasse = "com.gerenciador.action." + paramAction;
        //Carrega a classe com o nome da String, cria uma unica vez a classe e deixa em memória, e devolve a classe
        // Utilizado o padrão de projetos command para criar a interface ação
        String nomeUrl = null;
        try {
            Class classe = Class.forName(nomeDaClasse);
            Acao action = (Acao) classe.newInstance();
            nomeUrl = action.execute(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new ServletException(e);
        }

        String[] pathUrl = nomeUrl.split(":");
        if(pathUrl[0].equals("forward")) {
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + pathUrl[1]);
            rd.forward(request, response);

        } else {
            response.sendRedirect(pathUrl[1]);

        }
    }
}
