<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Gerenciador - Servlet</title>

    <link rel="icon" href="public/images/logo-icon.png" />

    <link rel="stylesheet" href="public/css/main.css" />
    <link rel="stylesheet" href="public/css/page-landing.css" />
    <link rel="stylesheet" href="public/css/animations.css" />

    <link href="https://fonts.googleapis.com/css2?family=Nunito:wght@400;600;800&display=swap" rel="stylesheet">
</head>
<body>

<div id="page-landing">
    <div id="container">
        <header>
            <img
                    class="animate-up"
                    id="logo"
                    src="public/images/logo-icon.png"
                    alt="Logo" />

            <div class = "location animate-up">
                <strong>Servlet</strong>
                <p>Gerenciador de Empresas</p>
            </div>
        </header>

        <main>
            <h1 class="animate-up">Meu Primeiro Servlets</h1>

            <section class = "visit">
                <p class="animate-up">Seja bem vind@, espero que goste!</p>

                <a href="browse?action=AdicionarEmpresa" title="Adicionar Empresas" class="animate-up">
                    Adicionar Empresa
                </a>
                <a href="browse?action=ListaEmpresas" title="Listar Empresas" class="animate-up">
                    Listar Empresas
                </a>
                <a href="browse?action=LoginForm" title="Login" class="animate-up">
                    Login
                </a>
            </section>
        </main>
    </div>
</div>
</body>
</html>