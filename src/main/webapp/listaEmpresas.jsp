<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.gerenciador.servlet.Empresa" %>
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
    <title>Java Standard Tag Library</title>
</head>
<body>
<a href="index.jsp">Voltar</a>
<br/><br/>

    <c:if test = "${not empty empresa}">
        Empresa ${ empresa } cadastrada com Sucesso!!!
    </c:if>
    <br/>

    Lista de empresas: <br/>
    <ul>
        <c:forEach var="empresa" items="${empresas}">
              <%-- empresa.getNome() é equivalente a linha abaixo --%>
            <li>
                    ${empresa.nome} - ${empresa.cnpj} - <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
                    <a href="./mostraEmpresa?id=${ empresa.id }">Editar</a>
                    <a href="./removeEmpresa?id=${ empresa.id }">Remover</a>
            </li>

        </c:forEach>
    </ul>
<p></p>
<br/>
<footer>Vou ficar devendo o front end dessa pagina por hora... </footer>
</body>
</html>
