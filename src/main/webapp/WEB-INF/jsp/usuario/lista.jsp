<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="br.edu.infnet.appvendas.model.domain.Comprador"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sistema de Gestao de Vendas</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">	
		
		<c:if test="${not empty nome}">
			<div class="alert alert-success">
				 <strong>Confirmacao!</strong> Usuario ${nome} cadastrado com sucesso!!!
			</div>
		</c:if>
		
		<c:if test="${not empty listaUsuarios}">
		
			<h4>Listagem de usuarios (${listaUsuarios.size()}):</h4>
			<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>#</th>
			        <th>Nome</th>
			        <th>Email</th>
			        <th>Compradores</th>
			        <th>Propriedades</th>
			        <th>Vendas</th>
			        <c:if test="${user.admin}">
			        	<th></th>
			        </c:if>
			      </tr>
			    </thead>
			    <tbody>
			    	<c:forEach var="u" items="${listaUsuarios}">
				      <tr>
				      	<td>${u.id}</td>
				        <td>${u.nome}</td>
				        <td>${u.email}</td>
				        <td>${u.compradores.size()}</td>
				        <td>${u.propriedades.size()}</td>
				        <td>${u.vendas.size()}</td>
				        <c:if test="${user.admin}">
				        	<td><a href="/usuario/${u.id}/excluir">
							<c:choose>
								<c:when test = "${user.id != u.id}">
								Excluir
								</c:when>
							</c:choose>
				        	</a>
				        	</td>
				        	
				        </c:if>
				      </tr>
			      </c:forEach>
			    </tbody>
		  	</table>
	  	</c:if>
	  			
	  	<c:if test="${empty listaUsuarios}">
	  		<h4>Nao existem usuarios cadastrados!</h4>
	  	</c:if>
	</div>
</body>
</html>