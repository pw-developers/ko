<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="dao.*" %>
<%@ page import="admin.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CRUD JSP-Servlet</title>
</head>
<body>

	<% UsuarioDAO userMod = new UsuarioDAO(); %>
	<a href="./addUser.jsp">Inserir novo usuário</a>
	<br>
	<table cellpadding="2" cellspacing="2" border="1">
		<tr>
			<th>Id</th>
			<th>Login</th>
			<th>Senha</th>
		</tr>
		<c:forEach var="p" items="<%= userMod.findAll() %>">
			<tr>
				<td>${p.id}</td>
				<td>${p.login}</td>
				<td>${p.senha}</td>
				<td>
					<a href="/ko/UserServlet?comando=deletar&id=${p.id}" onclick="return confirm('Você tem certeza?')">Deletar</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>