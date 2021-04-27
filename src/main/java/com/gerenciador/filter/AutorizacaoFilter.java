package com.gerenciador.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(filterName = "AutorizacaoFilter", urlPatterns = "/browse")
public class AutorizacaoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws ServletException, IOException {

        //Precisa ser feito um cast, pois o filter é um tipo mais generics de servlet e precisa ser HttpServlet (mais especifica);
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String paramAction = request.getParameter("action");

        //Verifica se possui um JSessionID (para saber se está logado), caso não tenha uma, será redirecionado para criar.
        HttpSession session = request.getSession();
        boolean userNotLogged = (session.getAttribute("userSession") == null);
        // Verifica se a página que está acessando é uma das que não precisam de autenticação, que são todas, exceto o form de login
        boolean ehUmaAcaoProtegida = !(paramAction.equals("Login") || paramAction.equals("LoginForm"));

        if(ehUmaAcaoProtegida && userNotLogged) {
            response.sendRedirect("browse?action=LoginForm");
            return;
        }

        chain.doFilter(request, response);
    }
}
