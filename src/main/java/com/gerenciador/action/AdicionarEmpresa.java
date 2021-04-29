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

public class AdicionarEmpresa implements Acao {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        return "forward:formNovaEmpresa.jsp";

    }
}
