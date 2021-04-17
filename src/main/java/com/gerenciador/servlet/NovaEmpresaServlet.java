package com.gerenciador.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "NovaEmpresaServlet", urlPatterns = "/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Cadastrando empresa...");

        String nomeEmpresa = request.getParameter("nome");
        String paramData = request.getParameter("data");
        String paramCnpj = request.getParameter("cnpj"); //recebe valor do cnpj e salva

        Date dataAbertura = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dataAbertura = dateFormat.parse(paramData);

        } catch (ParseException e) {
            throw new ServletException(e);
        }

        Empresa novaEmpresa = new Empresa();
        novaEmpresa.setNome(nomeEmpresa);
        novaEmpresa.setDataAbertura(dataAbertura);
        novaEmpresa.setCnpj(paramCnpj);

        Banco bancoDAO = new Banco();
        bancoDAO.adiciona(novaEmpresa);

        request.setAttribute("empresa", novaEmpresa.getNome());

        response.sendRedirect("listaEmpresas");

//        // chamar a página JPS
//        RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
//        // vai carregar o atributo em comum na requisição a ser usado na JSP
//        request.setAttribute("empresa", novaEmpresa.getNome());
//        // Vai levar a requisição e a a nossa resposta - como se fosse um 'motoboy'.
//        rd.forward(request, response);

    }
}
