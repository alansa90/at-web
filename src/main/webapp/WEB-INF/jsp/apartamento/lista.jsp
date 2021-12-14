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
		
		<a href="/apartamento">Novo Apartamento</a>

        <hr>
		<c:if test="${not empty msg}">
            <div class="alert alert-danger">
        	    <strong>Atenção!</strong> ${msg}
        	</div>
        </c:if>
		<c:if test="${not empty nome}">
			<div class="alert alert-success">
				 <strong>Confirmacao!</strong> O Apartamento ${descricao} foi cadastrado com sucesso!!!
			</div>
		</c:if>
		
		<c:if test="${not empty listaApartamentos}">
		
			<h4>Listagem de Apartamentos (${listaApartamentos.size()}):</h4>
			<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>#</th>
			        <th>Descricao</th>
			        <td>Numero</td>
			        <td>Andar</td>
                    <th>Area</th>
                    <th>valor</th>
                    <th>Situacao</th>
			        <th></th>
			      </tr>
			    </thead>
			    <tbody>
			    	<c:forEach var="p" items="${listaApartamentos}">
				      <tr>
				      	<td>${p.id}</td>
                        <td>${p.descricao}</td>
                        <td>${p.numero}</td>
                        <td>${p.andar}</td>
                        <td>${p.areaTotal}</td>
                        <td>${p.valorPropriedade}</td>
                        <td>${p.situacao}</td>
				        <td><a href="/apartamento/${p.id}/excluir">Excluir</a></td>
				      </tr>
			      </c:forEach>
			    </tbody>
		  	</table>
	  	</c:if>
	  			
	  	<c:if test="${empty listaApartamentos}">
	  		<h4>Nao existem apartamentos cadastrados!</h4>
	  	</c:if>
	</div>
</body>
</html>