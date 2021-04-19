<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/browse" var="linkMainServlet"/>

<!DOCTYPE html>
<html lang="pt_BR">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Formulario de Cadastro</title>
</head>
<body>
<a href="../../gerenciador/">Voltar</a>
<br/><br/>

    <form action="${ linkMainServlet }" method="post">

        Nome: <input type="text" name="nome" />
        CNPJ: <input type="text" name="cnpj">
        Data de Abertura: <input type="text" name="data" />
        <input type="hidden" name="action" value="NovaEmpresa" />

        <input type="submit">

    </form>
<p></p>
<br/>
<footer>Vou ficar devendo o front end dessa pagina por hora... </footer>
</body>
</html>