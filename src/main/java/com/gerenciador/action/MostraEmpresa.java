package com.gerenciador.action;

import com.gerenciador.model.Banco;
import com.gerenciador.model.Empresa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MostraEmpresa {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Mostrando dados da empresa...");

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
