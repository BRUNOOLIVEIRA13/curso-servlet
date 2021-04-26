package com.gerenciador.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Logout implements Acao {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
//        session.removeAttribute("userSession"); -> não é uma boa prática
        //invalida toda a sessão e destrói o cookie:
        session.invalidate();
        return "redirect:browse?action=LoginForm";
    }
}
