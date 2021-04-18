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

public class AlteraEmpresa {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nomeEmpresa  = request.getParameter("nome");
        String paramData    = request.getParameter("data");
        String paramId      = request.getParameter("id");
        Integer id          = Integer.valueOf(paramId);

        System.out.println("Ação de alterar empresa ID: " + id);

        Date dataAbertura = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            dataAbertura = sdf.parse(paramData);
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        Banco banco = new Banco();
        Empresa empresa = banco.searchById(id);
        empresa.setNome(nomeEmpresa);
        empresa.setDataAbertura(dataAbertura);

        response.sendRedirect("browse?action=ListaEmpresas");

    }
}
