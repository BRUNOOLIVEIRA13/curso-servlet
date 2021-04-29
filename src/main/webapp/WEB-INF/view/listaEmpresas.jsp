<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.gerenciador.model.Empresa" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Bruno
  Date: 11/04/2021
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Gerenciador - Lista de Empresas</title>
</head>
<body>
    <c:import url="logout-parcial.jsp" />

    <c:if test = "${not empty empresa}">
        Empresa ${ empresa } cadastrada com Sucesso!!!
    </c:if>

    <fieldset>
        <legend>Usuário Logado:</legend>
            <strong>${userSession.login}</strong>
    </fieldset>
    <br><br><br>

<fieldset>
    <legend><strong> Lista de empresas em ordem alfabética: </strong></legend>
    <ul>
        <c:forEach var="empresa" items="${empresas}">
              <%-- empresa.getNome() é equivalente a linha abaixo --%>
            <li>
                <strong>${empresa.nome}</strong> - CNPJ: ${empresa.cnpj} | Abertura de Conta: <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
                        <button>
                            <a href="./browse?action=MostraEmpresa&id=${ empresa.id }"> Editar </a>
                        </button>

                        <button>
                            <a href="./browse?action=RemoveEmpresa&id=${ empresa.id }"> Remover </a>
                        </button>
            </li>

        </c:forEach>
    </ul>
<p></p>
<br/>
</fieldset>

</body>
</html>
