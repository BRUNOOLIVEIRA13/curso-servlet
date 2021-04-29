<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/browse" var="linkMainServlet"/>

<!DOCTYPE html>
<html lang="pt_BR">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Cadastro de Empresas</title>

</head>
<body>
    <c:import url="logout-parcial.jsp" />

    <main class="animate-appear with-sidebar">
        <form action="${ linkMainServlet }" method="post">
            <fieldset>
                <legend>Cadastro de Empresa</legend>
                <div class="input-block">
                    <label for="nome">Razão Social:</label>
                    <input type="text" id="nome" name="nome" required />
                </div>
                <p></p>
                <div class="input-block">
                    <label for="cnpj">CNPJ:</label>
                    <input id="cnpj" name="cnpj" maxLength = 18 required />
                </div>
                <p></p>
                <div class="input-block">
                    <label for="data">Data de Abertura:</label>
                    <input id="data" name="data" required />
                </div>
                <p></p>
                <input type="hidden" name="action" value="NovaEmpresa" />
                <button type="submit" class="primary-button">Confirmar</button>

            </fieldset>
        </form>
    </main>

</body>
</html>