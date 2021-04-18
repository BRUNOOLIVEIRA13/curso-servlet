package com.gerenciador.servlet;

import com.gerenciador.action.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MainServlet", value = "/browse") //entrada única
public class MainServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String paramAction = request.getParameter("action"); //ação

        switch (paramAction) {
            case "ListaEmpresas": { //criar um objeto que não é um servlet, colocamos a ação e encapsulamos/delegamos a execução.
                ListaEmpresas action = new ListaEmpresas();
                action.execute(request, response);

                break;
            }
            case "RemoveEmpresa": {
                RemoveEmpresa action = new RemoveEmpresa();
                action.execute(request, response);

                break;
            }
            case "MostraEmpresa": {
                MostraEmpresa action = new MostraEmpresa();
                action.execute(request, response);

                break;
            }
            case "AlteraEmpresa": {
                AlteraEmpresa action = new AlteraEmpresa();
                action.execute(request, response);

                break;
            }
            case "NovaEmpresa": {
                NovaEmpresa action = new NovaEmpresa();
                action.execute(request, response);
                break;
            }
        }
    }

}
