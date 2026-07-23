<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="index.css">
<meta charset="UTF-8">
<title>Primeira Aula JSP</title>
</head>
<body>

<h1>Primeira aula de JSP</h1>

<%
    // Data e hora
    Date hoje = new Date();
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    // Recebendo os dados do formulário
    String nome = request.getParameter("nome");
    String idadeTexto = request.getParameter("idade");
    String cidade = request.getParameter("cidade");

    // Valores padrão
    if (nome == null || nome.isEmpty()) {
        nome = "Visitante";
    }
	
%>

<p class="entrada">Olá, <%= nome %>.</p>

<hr>

<h2>Dados do Usuário</h2>

<p><strong>Nome:</strong> <%= nome %></p>

<hr>

<h2>Números de 1 a 5</h2>

<%
for (int i = 1; i <= 5; i++) {
%>

<p class="entrada">Número: <%= i %><br></p>

<%
}
%>

<hr>

<footer>
    <h3>Informações da Página</h3>

    <p><strong>Data e Hora:</strong> <%= formato.format(hoje) %></p>
</footer>

<a href="cadastro.jsp">Ir para Cadatro</a>

</body>
</html>