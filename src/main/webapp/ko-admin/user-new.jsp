<jsp:include page="/ko-admin/assets/includes/header.html"></jsp:include>

<!-- Admin Panel Start -->
<section id="users">
	<jsp:include page="/ko-admin/assets/includes/navbar.html"></jsp:include>

	<form action="login-admin.ko">
		<div class="container-fluid main-container">
			<div class="formulario_add_new_user">
				<div>
					<div class="your-name-user">
						<label class="sr-only">Nome de Usuário</label><input type="text"
							name="login-usuario" size="40">
					</div>
					<div class="your-email">
						<label class="sr-only">Email</label><input type="text"
							name="email-usuario" size="40">
					</div>
					<div class="your-first-name">
						<label class="sr-only">Nome</label><input type="text"
							name="nome-usuario" size="40">
					</div>
					<div class="your-last-name">
						<label class="sr-only">Sobrenome</label><input type="text"
							name="sobrenome-usuario" size="40">
					</div>
					<div class="your-password">
						<label class="sr-only">Senha</label><input type="text"
							name="senha-usuario" size="40">
					</div>
					<div class="your-password-again">
						<label class="sr-only">Repetir Senha</label><input type="text"
							name="repetir-senha-usuario" size="40">
					</div>
					<div>
						<input type="submit" name="comando" value="Adicionar novo Usuário" class="btn btn-lg btn-block">
					</div>
				</div>
			</div>
		</div>
	</form>
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