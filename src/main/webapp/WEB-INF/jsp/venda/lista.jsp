<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="br.edu.infnet.appvendas.model.domain.Venda"%>
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
		
		<a href="/venda">Nova venda</a>
	
		<hr>
		
		<c:if test="${not empty descricao}">
			<div class="alert alert-success">
				 <strong>Confirmacao!</strong> Venda ${descricao}, cadastrada com sucesso!!!
			</div>
		</c:if>
		
		<c:if test="${not empty listaVendas}">

		
			<h4>Listagem de Vendas (${listaVendas.size()}):</h4>
			<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>#</th>
			        <th>Descricao</th>
			        <th>Comprador</th>
			        <th>Propriedade</th>
			        <th></th>
			      </tr>
			    </thead>
			    <tbody>
			    	<c:forEach var="p" items="${listaVendas}">
				      <tr>
				      	<td>${p.id}</td>
				        <td>${p.descricao}</td>
				        <td>${p.comprador.nome}</td>
				        <td>${p.propriedade.size()}</td>
				        <td><a href="/venda/${p.id}/excluir">Excluir</a></td>
				      </tr>
			      </c:forEach>
			    </tbody>
		  	</table>
	  	</c:if>
	  			
	  	<c:if test="${empty listaVendas}">
	  		<h4>Nao existem vendas cadastradas!</h4>
	  	</c:if>
	</div>
</body>
</html>