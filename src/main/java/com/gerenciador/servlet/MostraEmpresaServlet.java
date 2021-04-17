package com.gerenciador.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MostraEmpresaServlet", value = "/mostraEmpresa")
public class MostraEmpresaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Precisa requisitar os parametros e converter para inteiro
        String paramId = request.getParameter("id");
        Integer id = Integer.valueOf(paramId);

        // Simulando o comportamento do banco, onde ele ira buscar a empresa pelo ID
        Banco banco = new Banco();
        Empresa empresa = banco.searchById(id);

        System.out.println(empresa.getNome());

        // Definindo o atributo a ser enviado
        request.setAttribute("empresa", empresa);

        // Definindo a rota e enviando
        RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
        rd.forward(request, response);

    }

}
