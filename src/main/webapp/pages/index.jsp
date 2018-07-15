<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="est" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Todo Admin</title>
<link rel="stylesheet" type="text/css"
	href="/resources/bootstrap4/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
<link rel="shortcut icon" href="/resources/list.ico?"
	type="image/x-icon" />

</head>
<body>
	<div class="header col-md-12 col-sm-8">
		<a href="/" class="logo">Administrador de tareas</a>
		<div class="header-right">

			<a href="${pageContext.request.contextPath}/list">Tareas</a> <a
				href="${pageContext.request.contextPath}/listHecho">Tareas
				Finalizadas</a> <a href="${pageContext.request.contextPath}/listEstado">Estados</a>

		</div>
	</div>
	<div class="col-sm-12 par2 jumbotron jumbotron-fluid justify-content-center align-items-center">

		<div class="parrafo row center_element">

			<div class="container ">
				<h2 class="center_element">No sabes como llevar un control de tus deberes?</h2>

			</div>

		</div>
		<div class="parrafo row ">
			<div class="container ">
				<p class="center_element">Administra tus tareas</p>
			</div>
		</div>

		<div class="parrafo row">
			<div class="container ">
				<p class="center_element">Nuestra herramienta de administracion de tareas, te permite
					llevar un registro de forma oportuna, sin dejar de lado el nivel de
					importancia de cada una de ellas
				<p>
			</div>
		</div>


	</div>


	<footer class="page-footer font-small unique-color-dark pt-4 footer">

		<div class="container">


			<ul class="list-unstyled list-inline text-center py-4">
				<li class="list-inline-item">
					<h5 class="mb-1">
						<p>"No dejes para mañana lo que puedas hacer hoy"</p>
						<p>"Benjamin Franklin"</p>
					</h5>
				</li>

			</ul>


		</div>

		<div class="footer-copyright text-center py-3">© 2018 Copyright
		</div>

	</footer>

</body>
</html>