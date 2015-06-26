<jsp:include page="/ko-admin/assets/includes/header.html"></jsp:include>
<jsp:include page="/ko-admin/assets/includes/navbar.html"></jsp:include>
<%@ page import="dao.*" %>
<%@ page import="admin.*" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.persistence.*" %>

<!-- Edit User Start -->
<section id="user-edit">

	<div class="container-fluid main-container-admin">
		<div class="col-md-2 sidebar">
			<jsp:include page="/ko-admin/assets/includes/sidebar.html"></jsp:include>
		</div>
		<div class="col-md-6 content">
			<div class="row">
				<p class="title-add-new-user">Editar Usuário</p>
			</div>
			<form action="/ko/UserServlet?comando=salvar">
				<div class="container-fluid main-container-admin">
					<div class="formulario_add_new_user">
						<div>
							<div class="your-name-user form-margin">
								<label>Id</label>${userEdit.id }<input type="hidden"
									name="id-usuario" value="${userEdit.id }">
							</div>
							<div class="your-first-name form-margin">
								<label>Nome</label><input type="text"
									name="nome-usuario" value="${userEdit.nome }" size="40" class="input-admin">
							</div>
							<div class="your-last-name form-margin">
								<label>Sobrenome</label><input type="text"
									name="sobrenome-usuario" value="${userEdit.sobreNome }" size="40" class="input-admin">
							</div>
							<div class="your-email form-margin">
								<label>Email</label><input type="text"
									name="email-usuario" value="${userEdit.email }" size="40" class="input-admin">
							</div>
							<div class="your-name-user form-margin">
								<label>Nome de Usuário</label><input type="text"
									name="login-usuario" value="${userEdit.login }" size="40" class="input-admin">
							</div>
							<div class="your-password-again form-margin">
								<label>Repetir Senha</label><input type="text"
									name="repetir-senha-usuario" value="${userEdit.senha }" size="40" class="input-admin">
							</div>
							<div class="your-password form-margin">
								<label>Senha</label><input type="text"
									name="senha-usuario" value="${userEdit.senha }" size="40" class="input-admin">
							</div>
							<div>
								<input type="submit" name="comando"
									value="editar" class="btn btn-lg btn-block">
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
		<div class="col-md-4 content"></div>
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