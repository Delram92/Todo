<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="com.google.appengine.api.datastore.KeyFactory"%>
<%@ page import="com.prueba.todo.model.TodoEstado"%>


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

	<div class="panel panel-default">
		<div
			class=" panel-heading parrafo  col-sm-12 row h-100 justify-content-center align-items-center">
			<div class="row ">
				<h2 class="text-uppercase font-weight-light text">Crear Estado</h2>
			</div>
		</div>

		<div
			class="parrafo row col-sm-12 row h-100 justify-content-center align-items-center">
			<div class="panel-body">
				<div class="row error">
					<p>${message}</p>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="col-sm-10 col-sm-offset-2">

			<form method="post" action="addEstado">

				<div class="row form-group">
					<label for="nombre" class="col-4 col-form-label">Nombre: </label>
					<div class="col-8">
						<input class=" form-control" type="text" name="nombre" id="nombre"
							required="required" placeholder="Nombre" />
					</div>
				</div>

				<div class="row form-group">

					<label for="descripcion" class="col-4 col-form-label">Descripcion</label>
					<div class="col-8">
						<input class="form-control" type="text" style="height: 100px;"
							name="descripcion" id="descripcion" required="required" />
					</div>

				</div>


	<div class="container col-12 center btn-group">
					<div class="btn-group mr-2 " role="group"
						aria-label="First group">

						<input type="submit" class=" btn btn-primary" title="Save"
							value="Salvar" />


					</div>
					<div class="btn-group mr-2" role="group" aria-label="Second group">
					<a class=" btn btn-primary "	href="${pageContext.request.contextPath}/listEstado">Regresar</a>
					</div>
				</div>

			</form>
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
