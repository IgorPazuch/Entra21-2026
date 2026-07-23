<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <link rel="stylesheet" href="cadastro.css">

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro</title>
</head>
<body>

<h1>Cadastro</h1>

<hr>

<form action="processaCadastro.jsp" method="POST">

    <label>Nome: </label>
    <input type="text" placeholder="Igor" name="nome">

    <br>
    
    <label>Email: </label>
    <input type="email" placeholder="example@example.com" name="email">

    <br>

    <button>Enviar</button>

</form>

<hr>

<a href="index.jsp">Voltar</a>

</body>
</html>