package com.gerenciador.action;

import com.gerenciador.model.Banco;
import com.gerenciador.model.Empresa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class ListaEmpresas implements Acao {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Listando empresas ...");

        //Dá acesso a sessão (JSESSONID), caso não tenha uma, será criada.
        HttpSession session = request.getSession();
        if(session.getAttribute("userSession") == null) {
            return "redirect:browse?action=LoginForm";
        }

        Banco banco = new Banco();
        List<Empresa> lista = banco.getEmpresas();

        lista.sort(Comparator.comparing(Empresa::getNome));

        request.setAttribute("empresas", lista);

        return "forward:listaEmpresas.jsp";

    }

}
