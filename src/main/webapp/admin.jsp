<%@include file="../assets/includes/header.html"%>

${campoX}

<!-- Login Start -->
<section id="admin" class="pfblock">
	<div class="row">
		<div class="back-to-home btn btn-lg">
			<a href="/ko/ko?caminho=index"><span class="glyphicon glyphicon-circle-arrow-left"></span>Voltar
				para P�gina Inicial</a>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="login-img">
				<p>
					<img src="/ko/assets/images/logo-ko.png" />
				</p>
			</div>
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Administra��o</h3>
					</div>
					<div class="panel-body">
						<form accept-charset="UTF-8" role="form" action="/login-admin.ko">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="Usu�rio" name="login"
										type="text">
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Senha" name="senha"
										type="password" value="">
								</div>
								<div class="checkbox">
									<label> <input name="remember" type="checkbox"
										value="Remember Me"> Lembrar-me
									</label>
								</div>
								<input name="comando" class="btn btn-lg btn-success btn-block" type="submit"
									value="Entrar">
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<%@include file="../assets/includes/footer.html"%>

<!-- Scripts -->
<script src="assets/js/jquery-1.11.1.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/imagesloaded.pkgd.js"></script>
<script src="assets/js/jquery.sticky.js"></script>
<script src="assets/js/smoothscroll.js"></script>
<script src="assets/js/wow.min.js"></script>
<script src="assets/js/jquery.easypiechart.js"></script>
<script src="assets/js/waypoints.min.js"></script>
<script src="assets/js/jquery.cbpQTRotator.js"></script>
<script src="assets/js/custom.js"></script>
</body>
</html>
