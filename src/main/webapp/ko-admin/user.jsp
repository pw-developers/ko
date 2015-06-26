<jsp:include page="/ko-admin/assets/includes/header.html"></jsp:include>
<jsp:include page="/ko-admin/assets/includes/navbar.html"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="dao.*" %>
<%@ page import="admin.*" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.persistence.*" %>

<!-- Users Start -->
<section id="users">

	<div class="container-fluid main-container">
		<div class="col-md-2 sidebar">
			<jsp:include page="/ko-admin/assets/includes/sidebar.html"></jsp:include>
		</div>
		<div class="col-md-10 content">
			<div>
				<a href="/ko/UserServlet?comando=addUser"
					class="btn btn-lg btn-block">Adicionar Novo</a>
			</div>
			<table cellpadding="2" cellspacing="2" border="1">
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Sobre Nome</th>
					<th>E-Mail</th>
					<th>Login</th>
					<th>Senha</th>
				</tr>
				<c:forEach var="p" items="${listaUsuarios}">
					<tr>
						<td>${p.id}</td>
						<td>${p.nome}</td>
						<td>${p.sobreNome}</td>
						<td>${p.email}</td>
						<td>${p.login}</td>
						<td>${p.senha}</td>
						<td><a href="/ko/UserServlet?comando=deletar&id-usuario=${p.id}"
							onclick="return confirm('Você tem certeza?')">Deletar</a></td>
						<td><a href="/ko/UserServlet?comando=editUser&id-usuario=${p.id}">Editar</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</section>
<jsp:include page="/ko-admin/assets/includes/footer.html"></jsp:include>

<!-- Scripts -->
<script src="http://localhost:9090/ko/assets/js/jquery-1.11.1.min.js"></script>
<script
	src="http://localhost:9090/ko/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="http://localhost:9090/ko/assets/js/imagesloaded.pkgd.js"></script>
<script src="http://localhost:9090/ko/assets/js/jquery.sticky.js"></script>
<script src="http://localhost:9090/ko/assets/js/smoothscroll.js"></script>
<script src="http://localhost:9090/ko/assets/js/wow.min.js"></script>
<script src="http://localhost:9090/ko/assets/js/jquery.easypiechart.js"></script>
<script src="http://localhost:9090/ko/assets/js/waypoints.min.js"></script>
<script src="http://localhost:9090/ko/assets/js/jquery.cbpQTRotator.js"></script>
<script src="http://localhost:9090/ko/assets/js/custom.js"></script>
<script src="http://localhost:9090/ko/assets/js/custom.js"></script>
</body>
</html>