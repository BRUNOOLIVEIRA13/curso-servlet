package com.gerenciador.controller;

import com.gerenciador.action.Acao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "ControllerServlet", value = "/browse") //entrada única
public class ControllerServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String paramAction = request.getParameter("action");

        String nomeDaClasse = "com.gerenciador.action." + paramAction;
        //Carrega a classe com o nome da String, cria uma unica vez a classe e deixa em memória, e devolve a classe
        // Utilizado o padrão de projetos command para criar a interface acao
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
/*
        String nomeUrl = null;
        //criamos um objeto que não é um controller, colocamos a ação e encapsulamos/delegamos a execução.
        if (paramAction.equals("ListaEmpresas")) {
            ListaEmpresas action = new ListaEmpresas();
            nomeUrl = action.execute(request, response);

        } else if (paramAction.equals("RemoveEmpresa")) {
            RemoveEmpresa action = new RemoveEmpresa();
            nomeUrl = action.execute(request, response);

        } else if (paramAction.equals("MostraEmpresa")) {
            MostraEmpresa action = new MostraEmpresa();
            nomeUrl = action.execute(request, response);

        } else if (paramAction.equals("AlteraEmpresa")) {
            AlteraEmpresa action = new AlteraEmpresa();
            nomeUrl = action.execute(request, response);

        } else if (paramAction.equals("NovaEmpresa")) {
            NovaEmpresa action = new NovaEmpresa();
            nomeUrl = action.execute(request, response);

        } else if (paramAction.equals("AdicionarEmpresa")) {
            // Para criar uma nova empresa - classe que chama o formulário 'formNovaEmpresa.jsp'
            AdicionarEmpresa action = new AdicionarEmpresa();
            nomeUrl = action.execute(request, response);
        }
*/
    }
}
