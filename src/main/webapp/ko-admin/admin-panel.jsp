
<%@include file="../assets/includes/header.html"%>

<!-- Admin Panel Start -->
<section id="admin-panel">

	<%@include file="../ko-admin/assets/includes/navbar.html"%>
	<div class="container-fluid main-container">
		<div class="col-md-2 sidebar">
			<div class="row">
				<!-- uncomment code for absolute positioning tweek see top comment in css -->
				<div class="absolute-wrapper"></div>
				<!-- Menu -->
				<div class="side-menu">
					<nav class="navbar navbar-default" role="navigation">
						<!-- Main Menu -->
						<div class="side-menu-container">
							<ul class="nav navbar-nav">
								<li class="active"><a href="#"><span
										class="glyphicon glyphicon-dashboard"></span> Painel</a></li>
								<li><a href="#"><span class="glyphicon glyphicon-plane"></span>
										Active Link</a></li>
								<li><a href="#"><span class="glyphicon glyphicon-cloud"></span>
										Link</a></li>

								<!-- Dropdown-->
								<li class="panel panel-default" id="dropdown"><a
									data-toggle="collapse" href="#dropdown-lvl1"> <span
										class="glyphicon glyphicon-user"></span> Sub Level <span
										class="caret"></span>
								</a> <!-- Dropdown level 1 -->
									<div id="dropdown-lvl1" class="panel-collapse collapse">
										<div class="panel-body">
											<ul class="nav navbar-nav">
												<li><a href="#">Link</a></li>
												<li><a href="#">Link</a></li>
												<li><a href="#">Link</a></li>

												<!-- Dropdown level 2 -->
												<li class="panel panel-default" id="dropdown"><a
													data-toggle="collapse" href="#dropdown-lvl2"> <span
														class="glyphicon glyphicon-off"></span> Sub Level <span
														class="caret"></span>
												</a>
													<div id="dropdown-lvl2" class="panel-collapse collapse">
														<div class="panel-body">
															<ul class="nav navbar-nav">
																<li><a href="#">Link</a></li>
																<li><a href="#">Link</a></li>
																<li><a href="#">Link</a></li>
															</ul>
														</div>
													</div></li>
											</ul>
										</div>
									</div></li>

								<li><a href="#"><span
										class="glyphicon glyphicon-signal"></span> Link</a></li>

							</ul>
						</div>
						<!-- /.navbar-collapse -->
					</nav>

				</div>
			</div>
		</div>
		<div class="col-md-10 content">
			<div class="panel panel-default">
				<div class="panel-heading">Dashboard</div>
				<div class="panel-body">Lorem ipsum dolor sit amet,
					consectetur adipisicing elit, sed do eiusmod tempor incididunt ut
					labore et dolore magna aliqua. Ut enim ad minim veniam, quis
					nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
					consequat. Duis aute irure dolor in reprehenderit in voluptate
					velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint
					occaecat cupidatat non proident, sunt in culpa qui officia deserunt
					mollit anim id est laborum.</div>
			</div>
		</div>
	</div>
</section>
<%@include file="../ko-admin/assets/includes/footer.html"%>

<!-- Scripts -->
<script src="../assets/js/jquery-1.11.1.min.js"></script>
<script src="../assets/bootstrap/js/bootstrap.min.js"></script>
<script src="../assets/js/imagesloaded.pkgd.js"></script>
<script src="../assets/js/jquery.sticky.js"></script>
<script src="../assets/js/smoothscroll.js"></script>
<script src="../assets/js/wow.min.js"></script>
<script src="../assets/js/jquery.easypiechart.js"></script>
<script src="../assets/js/waypoints.min.js"></script>
<script src="../assets/js/jquery.cbpQTRotator.js"></script>
<script src="../assets/js/custom.js"></script>
<script src="assets/js/custom.js"></script>
</body>
</html>