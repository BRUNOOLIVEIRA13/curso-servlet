<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url value="/browse" var="linkMainServlet"/>

<!DOCTYPE html>
<html lang="pt_BR">
<head>
    <meta charset="UTF-8">
    <title>Alterar Cadastro</title>
</head>
<body>

<a href="index.jsp">Voltar</a>
<br/><br/>

    <form action="${ linkMainServlet }" method="post">

        Nome: <input type="text" name="nome" value="${empresa.nome}"/>
        CNPJ: <input type="text" name="cpng" value="${empresa.cnpj }" readonly>
        Data de Abertura: <input type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>" />

        <input type="hidden" name="id" value="${empresa.id}" />
        <input type="hidden" name="action" value="AlteraEmpresa" />
        <input type="submit">

    </form>

</body>
</html>