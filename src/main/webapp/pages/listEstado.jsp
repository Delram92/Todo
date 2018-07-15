<%@ page import="java.util.List"%>
<%@ page import="com.prueba.todo.model.TodoEstado"%>
<%@ page import="com.google.appengine.api.datastore.KeyFactory"%>


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




	<div class="container  col-sm-12">
		<div class="panel panel-default">
			<div
				class=" panel-heading parrafo  col-sm-12 row h-100 justify-content-center align-items-center">
				<div class="row ">
					<h2 class="text-uppercase font-weight-light text">Lista
						Estados</h2>

				</div>
				<div class="container col-12 center btn-group">
					<div class="btn-group mr-2 " role="group">
						<a href="addEstado" class=" btn btn-primary">Crear Estado</a></span>
					</div>
				</div>


			</div>
		</div>
</div>



		<div class="container">
			<div class="col-sm-12">
				<div class="table-responsive">
					<table border="1" class="table table-striped  table-bordered">
						<thead>
							<tr>
								<th scope="col">Nombre</th>
								<th scope="col">Descripcion</th>

							</tr>
						</thead>

						<%
							if (request.getAttribute("listTodoEstado") != null) {

								List<TodoEstado> estado = (List<TodoEstado>) request.getAttribute("listTodoEstado");

								if (!estado.isEmpty()) {
									for (TodoEstado esta : estado) {
						%>
						<tr>
							<td><%=esta.getEstadoNombre()%></td>
							<td><%=esta.getDescripcion()%></td>

						</tr>
						<%
							}

								}

							}
						%>

						</tr>

					</table>
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