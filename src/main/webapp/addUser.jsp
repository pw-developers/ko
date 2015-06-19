<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Novo Usuario</title>
</head>
<body>
	<form action="/ko/UserServlet">
		<table cellpadding="2" cellspacing="2" border="1">
			<tr>
				<td>Login</td>
				<td><input type="text" name="login"></td>
			</tr>
			<tr>
				<td>Senha</td>
				<td><input type="text" name="senha"></td>
			</tr>
			<tr>
				<td colspan="2" align="left"><input type="submit" name="comando" value="salvar">Salvar</td>
			</tr>
		</table>
	</form>
</body>
</html>