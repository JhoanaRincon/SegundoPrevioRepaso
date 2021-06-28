<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <!-- para usar jstl -->
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de Votantes</title>
</head>
<body>
<header>
	<!-- barra de menu -->
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color:tomato">
			<div>
				<a href="#" class="navbar-brand">Elecciones : Votantes</a>
			</div>
			<!-- lista de usuarios -->
			<ul class="navbar-nav">
							<!-- referencia al origen del servlet, pide que llame a /list -->
				<li><a href="<%=request.getContextPath() %>/list" class="nav-link">Votantes</a></li>
			</ul>
		</nav>
	</header>
	<br/>	<div class="row">
	<div class="container">
		<h3 class="text-center">Listado de Votantes</h3>
		<hr>
		<div class="container text-left">
						<!-- referencia al origen del servlet, pide que llame a /new -->
			<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Agregar Votante</a>
		</div>
		<br>
		<table class="table table-bordered">
		<thead>
			<th>ID</th>
			<th>NOMBRE</th>
			<th>EMAIL</th>
			<th>DOCUMENTO</th>
			</tr>
		</thead>
		<tbody>
				<!-- for (Todo todo: todos) { -->
				<!-- se usa jstl -->
				<c:forEach var="votante" items="${listadoVotantes}"> <!-- me permite acceder a al listUsuario del metodo listUsuario de la clase Usuarioervlet -->
					<tr>
						<td>
							<!-- es necesario tener los get y set, ya que jstl accede a ellos -->
							<c:out value="${votante.id}" /> 
						</td>
						<td>
							<c:out value="${votante.nombre}" />
						</td>
						<td>
							<c:out value="${votante.email}" />
						</td>
						<td>
							<c:out value="${votante.documento}" />
						</td>
							<!-- para editar y se envia el id del usuario a editar-->                             <!-- para eliminar y se envia el id del usuario a eliminar-->
						<td><a href="edit?id=<c:out value='${votante.id}' />">Editar</a> &nbsp;&nbsp;&nbsp;&nbsp; 
							<a href="delete?id=<c:out value='${votante.id}' />">Eliminar</a>
							</td>
					</tr>
				</c:forEach>
				<!-- } -->
			</tbody>
	</table>
	</div>
	</div>
</body>
</html>