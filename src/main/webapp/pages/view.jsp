<%@ page import="com.prueba.todo.model.Todo"%>
<%@ page import="java.util.List"%>
<%@ page import="com.prueba.todo.model.TodoEstado"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.DateFormat"%>


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

	<%
		DateFormat formatoFecha = new SimpleDateFormat("yyyy-mm-dd");
		Todo todo = new Todo();
	String fechaini="";
	String fechafin="";
		if(request.getAttribute("todo")!=null){
		
			todo = (Todo)request.getAttribute("todo");
			fechaini = formatoFecha.format(todo.getTodoFechaInicio());
			fechafin = formatoFecha.format(todo.getTodofechaFin());
			
		}
		
	%>

	<input type="hidden" name="userid" id="userid"
		value="<%=todo.getTodoid()%>" />



	<div class="panel panel-default">
		<div
			class=" panel-heading parrafo  col-sm-12 row h-100 justify-content-center align-items-center">
			<div class="row ">
				<h2 class="text-uppercase font-weight-light text">Detalle</h2>
			</div>
		</div>


	</div>








	<div class="container">
		<div class="col-sm-10 col-sm-offset-2">


			<div class="row form-group">
				<label for="nombre" class="col-4 col-form-label">Nombre: </label>
				<div class="col-8">
					<label class=" form-control"> <%=todo.getTodoNombre()%>
					</label>
				</div>
			</div>
			<div class="row form-group ">
				<label for="horas" class="col-4 col-form-label">Horas: </label>
				<div class="col-8">
					<label class=" form-control"> <%=todo.getTodoNumHoras()%>
					</label>
				</div>
			</div>

			<div class="row form-group">
				<label for="fechaini" class="col-4 col-form-label">Fecha
					Inicial: </label>
				<div class="col-8">
					<label class=" form-control"> <%=fechaini%>
					</label>
				</div>
			</div>

			<div class="row form-group">
				<label for="fechafin" class="col-4 col-form-label">Fecha
					Fin: </label>
				<div class="col-8">
					<label class=" form-control"> <%=fechafin%>
					</label>
				</div>
			</div>
			<div class="row form-group">
				<label for="estado" class="col-4 col-form-label">Estado: </label>
				<div class="col-8">
					<label class=" form-control"> <%=todo.getTodoEstado().getEstadoNombre()%>
					</label>
				</div>
			</div>

			<div class="row form-group">
				<label for="prioridad" class="col-4 col-form-label">Prioridad:
				</label>
				<div class="col-8">
					<label class=" form-control"> <%=todo.getPrioridad()%>
					</label>
				</div>
			</div>

			<div class="row form-group">

				<label for="descripcion" class="col-4 col-form-label">Descripcion</label>
				<div class="col-8">
					<p class=" form-control">
						<%=todo.getTodoDescripcion()%>
					</p>
				</div>

			</div>
	<div class="container col-12">
				<div class="container col-12 center btn-group">
					<div class="btn-group mr-2 " role="group">
					<a class=" btn btn-primary"
						href="${pageContext.request.contextPath}/list">Regresar</a></span>
					</div>
		

				
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
