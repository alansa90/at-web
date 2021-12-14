<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<c:if test="${not empty msg}">
            <div class="alert alert-danger">
                <strong>Atencao!</strong> ${msg}
            </div>
        </c:if>
		<c:if test="${not empty nome}">
			<div class="alert alert-success">
				 <strong>Confirmacao!</strong> A propriedade ${descricao} foi cadastrada com sucesso!!!
			</div>
		</c:if>
		
		<c:if test="${not empty listaPropriedades}">
		
			<h4>Listagem de propriedades (${listaPropriedades.size()}):</h4>
			<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>#</th>
			        <th>Descricao</th>
			        <th>Area</th>
			        <th>valor</th>
			        <th>Situacao</th>
			        <th></th>
			      </tr>
			    </thead>
			    <tbody>
			    	<c:forEach var="p" items="${listaPropriedades}">
				      <tr>
				      	<td>${p.id}</td>
				        <td>${p.descricao}</td>
				        <td>${p.areaTotal}</td>
				        <td>${p.valorPropriedade}</td>
				        <td>${p.situacao}</td>
				        <td><a href="/propriedade/${p.id}/excluir">Excluir</a></td>
				      </tr>
			      </c:forEach>
			    </tbody>
		  	</table>
	  	</c:if>
	  			
	  	<c:if test="${empty listaPropriedades}">
	  		<h4>Nao existem propriedades cadastradas!</h4>
	  	</c:if>
	</div>
</body>
</html>