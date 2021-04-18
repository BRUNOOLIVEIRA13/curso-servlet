package com.gerenciador.action;

import com.gerenciador.model.Banco;
import com.gerenciador.model.Empresa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NovaEmpresa {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nomeEmpresa = request.getParameter("nome");
        String paramData = request.getParameter("data");
        String paramCnpj = request.getParameter("cnpj"); //recebe valor do cnpj e salva

        System.out.println("Cadastrando nova empresa: " + nomeEmpresa);

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

        response.sendRedirect("browse?action=ListaEmpresas");

    }
}
