package com.gerenciador.action;

import com.gerenciador.model.Banco;
import com.gerenciador.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login implements Acao {

    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        System.out.println(login + " logando... ");

        Banco banco = new Banco();
        Usuario user = banco.validateCredentials(login, senha);

        if (user != null) {
            System.out.println("Usuário autenticado.");

            HttpSession session = request.getSession();
            session.setAttribute("userSession", user);

            return "redirect:browse?action=ListaEmpresas";
        } else {
            return "redirect:browse?action=LoginForm";
        }
    }

}