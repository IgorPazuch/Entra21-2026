<%@page import="dao.ContatoDao"%>
<%@page import="modelos.Contato"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Contatos</title>

<link rel="stylesheet" href="processaCadastro.css">

</head>

<body>

<%
   
   String nome = request.getParameter("nome");
   //out.print("<p>"+ nome +"</p>");
   
   String email = request.getParameter("email");
   //out.print("<p>"+ email +"</p>");
   
   Contato ct = new Contato();
   ct.setNome(nome);
   ct.setEmail(email);
   
   ContatoDao dao = new ContatoDao();
   dao.salvar(ct);
   
   List<Contato> contatos = dao.consultar();
   
   for(Contato c : contatos){
	   out.print("<p>"+c.getNome() + " "+ c.getEmail() +"</p>");
   }
   
   out.print("<hr />");
   out.print("<a href='cadastro.jsp'>Novo</a>");
%>

</body>
</html>
