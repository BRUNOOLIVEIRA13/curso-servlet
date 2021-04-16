package com.example.testando;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "oiServlet", urlPatterns = "/oi")
public class OiServlet extends HttpServlet {
    //OI
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter output = resp.getWriter();
        output.println("<html><body>");
        output.println("<h1> E ai, primeiro Servlet escrito ao mundo! </h1> ");
        output.println("</body></html>");

        System.out.println("Deu certo a execução!!!");

    }
}

