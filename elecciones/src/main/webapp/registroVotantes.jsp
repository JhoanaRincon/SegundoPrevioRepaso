<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- para usar jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head><title>Registrar Votante</title>
<!-- importar boostrap -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color:tomato">
			<div>
				<a href="#" class="navbar-brand">Votantes</a>
			</div>
			<ul class="navbar-nav">
				<!-- referencia al origen del servlet, pide que llame a /list -->
				<li><a href="<%=request.getContextPath() %>/list" class="nav-link">Votantes</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-S">
		<div class="card">
			<div class="card-body">
					<!-- una condicion para el usuario.-->
				<c:if test="${votante != null}">
					<!-- si no está vacio usa la accion update-->
					<form action="update" method="post">
				</c:if>
				<!-- una condicion para el usuario.-->
				<c:if test="${votante == null}">
					<!-- si está vacio usa la accion insert-->
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2>
					<!-- condicion: si no está vacio, muestre Editar Usuario-->
						<c:if test="${votante != null}">
							Editar Votante
						</c:if>
						<!-- condicion: si está vacio, muestre Agregar Nuevo Usuario-->
						<c:if test="${votante == null}">
							Agregar Votante
						</c:if>
					</h2>
				</caption>
				
				<!-- condicion: si no está vacio, traer el valor que esta en el value del input html-->
				<c:if test="${votante != null}">
					<input type="hidden" name="id" value="<c:out value='${votante.id}'/>"/>
				</c:if>
					<fieldset class="form-group">
					<label>Nombre Votante</label><input type="text" value="<c:out value='${votante.nombre}'/>" class="form-control" name="nombre" requerid="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Email del Votante</label><input type="text" value="<c:out value='${votante.email}'/>"class="form-control" name="email">
				</fieldset>
				<fieldset class="form-group">
					<label>Numero Documento</label><input type="text" value="<c:out value='${votante.documento}'/>"class="form-control" name="documento">
				</fieldset>
				<button type="submit" class="btn btn-success">Registrar Votante</button>
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>