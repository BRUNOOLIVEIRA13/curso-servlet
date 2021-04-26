<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <body>
    <c:import url="logout-parcial.jsp" />


    <c:if test = "${not empty empresa}">
            Empresa ${ empresa } cadastrada com Sucesso!!!
        </c:if>

        <c:if test = "${empty empresa}">
            Nenhuma empresa cadastrada! :(
        </c:if>

    </body>
</html>