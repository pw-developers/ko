<jsp:include page="/ko-admin/assets/includes/header.html"></jsp:include>
<jsp:include page="/ko-admin/assets/includes/navbar.html"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="dao.*"%>
<%@ page import="admin.*"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.persistence.*"%>

<!-- Users Start -->
<section id="users" class="pfblock-admin pfblock-gray">

	<div class="container-fluid">
		<div class="col-md-2 sidebar">
			<jsp:include page="/ko-admin/assets/includes/sidebar.html"></jsp:include>
		</div>
		<div class="col-md-10 content">
			<div class="row buffer-line">
				<div class="container-fluid buffer-line">
					<a href="/ko/UserServlet.ko?comando=addUser"
						class="btn btn-lg-light btn-block left medium">Adicionar Novo</a>
				</div>
			</div>
			<div class="row">
				<div class="container-fluid table-users">
					<table cellpadding="2" cellspacing="2" border="1">
						<tr>
							<th class="title-column">Id</th>
							<th class="title-column">Nome</th>
							<th class="title-column">Sobre Nome</th>
							<th class="title-column">E-mail</th>
							<th class="title-column">Login</th>
							<th class="title-column">Senha</th>
							<th class="title-column" colspan="2">Opções</th>
						</tr>
						<c:forEach var="p" items="${listaUsuarios}">
							<tr>
								<td class="tupla-element">${p.id}</td>
								<td class="tupla-element">${p.nome}</td>
								<td class="tupla-element">${p.sobreNome}</td>
								<td class="tupla-element">${p.email}</td>
								<td class="tupla-element">${p.login}</td>
								<td class="tupla-element">${p.senha}</td>
								<td class="table-button button-edit"><a
									href="/ko/UserServlet.ko?comando=editUser&id-usuario=${p.id}" title="Editar"><span
									class="glyphicon glyphicon-pencil"></span></a></td>
								<td class="table-button button-delet"><a
									href="/ko/UserServlet.ko?comando=deletar&id-usuario=${p.id}"
									onclick="return confirm('Você tem certeza?')" title="Deletar"><span
									class="glyphicon glyphicon-remove"></span></a></td>

							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</div>
</section>
<jsp:include page="/ko-admin/assets/includes/footer.html"></jsp:include>

<!-- Scripts -->
<script src="/ko/assets/js/jquery-1.11.1.min.js"></script>
<script src="/ko/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="/ko/assets/js/imagesloaded.pkgd.js"></script>
<script src="/ko/assets/js/jquery.sticky.js"></script>
<script src="/ko/assets/js/wow.min.js"></script>
<script src="/ko/assets/js/jquery.easypiechart.js"></script>
<script src="/ko/assets/js/waypoints.min.js"></script>
<script src="/ko/assets/js/jquery.cbpQTRotator.js"></script>
<script src="/ko/assets/js/custom.js"></script>
<script src="/ko/assets/js/validate.form.js"></script>

</body>
</html>