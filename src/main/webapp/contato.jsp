<%@include file="../assets/includes/header.html"%>
<%@include file="../assets/includes/menu-header.html"%>
<!-- Contact start -->

<section id="contact" class="pfblock pfblock-gray">
	<div class="container">
		<div class="localization">
			<div class="row">
				<div class="col-md-12">
					<iframe
						src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d30588.99142142371!2d-49.2768465!3d-16.595427!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x935e8ca95ca7ac0d%3A0x5aef9d28a91f27bb!2sUniversidade+Federal+de+Goi%C3%A1s!5e0!3m2!1spt-BR!2sbr!4v1430751956647"
						width="100%" height="300" frameborder="0" style="border: 0"></iframe>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
			<%String envioMSG;
			if(request.getAttribute("enviandoMsg") == null){
				envioMSG = "NULL";
			}else{
				envioMSG = (String) request.getAttribute("enviandoMsg");
			}

			if(!envioMSG.equals("NULL")){
			%>
				<small><i></i>Mensagens de alerta - Sucesso e Erro!</i></small>
				<%
				if(envioMSG.equals("true")){
				%>
				<div class="alert alert-success">
					<strong><span class="glyphicon glyphicon-send"></span>
						Mensagem enviada com Sucesso!</strong>
				</div>
				<%} else { %>
				<div class="alert alert-danger">
					<span class="glyphicon glyphicon-alert"></span><strong>
						Erro ao enviar a mensagem, tente mais tarde!<br>
						<%out.print((String) request.getAttribute("enviandoMsgErro")); %></strong>
				</div>
			<%	}
			}%>
			</div>
			<div class="col-sm-6">

				<div class="pfblock-header title-contact">
					<h2 class="pfblock-title ">Entre em contato</h2>
					<div class="pfblock-line"></div>
					<!-- 					<div class="pfblock-subtitle">No one lights a lamp in order -->
					<!-- 						to hide it behind the door: the purpose of light is to create more -->
					<!-- 						light, to open peopleâ€™s eyes, to reveal the marvels around.</div> -->
				</div>

			</div>

		</div>
		<!-- .row -->

		<div class="row">

			<div class="col-sm-6">

				<form id="contact-form" role="form" action="/ko/ko">
					<div class="ajax-hidden">
						<div class="form-group wow fadeInUp">
							<label class="sr-only" for="c_name">Name</label> <input
								type="text" id="c_name" class="form-control" name="c_name"
								placeholder="Nome">
						</div>

						<div class="form-group wow fadeInUp" data-wow-delay=".1s">
							<label class="sr-only" for="c_email">Email</label> <input
								type="email" id="c_email" class="form-control" name="c_email"
								placeholder="E-mail">
						</div>

						<div class="form-group wow fadeInUp" data-wow-delay=".2s">
							<textarea class="form-control" id="c_message" name="c_message"
								rows="7" placeholder="Menssagem"></textarea>
						</div>

						<button name="enviaMsg" value="enviando" type="submit" class="btn btn-lg btn-block wow fadeInUp animated"
							data-wow-delay=".3s">Enviar</button>
					</div>
					<div class="ajax-response"></div>
				</form>

			</div>
			<div class="col-sm-6 information-contact center-block">
				<hr class="featurette-divider hidden-lg">
				<div class="col-lg-6 col-md-push-1">
					<address>
						<h3>Endereço</h3>
						<p class="lead">
							<a href="https://goo.gl/maps/3Lp5d">Avenida Esperança, s/n -
								Setor Itatiaia <br> Goiânia - GO, 74690-900
							</a><br> Tel: +55 62 3521-1000<br> Cel: +55 62 9999-9999
						</p>
					</address>
				</div>
			</div>
		</div>
		<!-- .row -->
	</div>
	<!-- .container -->
</section>

	<!-- Contact end -->

	<!-- Get Footer -->
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