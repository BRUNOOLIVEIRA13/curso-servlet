<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/browse" var="linkMainServlet"/>

<!DOCTYPE html>
<html lang="pt_BR">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login</title>

</head>
<body>
    <button onclick="history.back()">Voltar</button>

    <br/><br/><br/><br/>
    <div class="input-block">
        <form action="${ linkMainServlet }" method="post">
            Login: <input type="text" name="login" /> <br>
            Senha: <input type="password" name="senha" />
            <input type="hidden" name="action" value="Login" /> <br> <br>

            <button type="submit" class="primary-button">ENTRAR</button>

        </form>
    </div>
<p></p>
<br/><br/>
<footer> Login: admin | senha: 1234 </footer>
</body>
</html>