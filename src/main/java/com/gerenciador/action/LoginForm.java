package com.gerenciador.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginForm implements Acao {

    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // vai apensar chamar e redirecionar para o formulário de login

        return "forward:formLogin.jsp";
    }
}
