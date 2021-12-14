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
		
		<a href="/casa">Nova Casa</a>
	
		<hr>
		<c:if test="${not empty msg}">
            <div class="alert alert-danger">
                <strong>Atencao!</strong> ${msg}
            </div>
        </c:if>
		<c:if test="${not empty nome}">
			<div class="alert alert-success">
				 <strong>Confirmacao!</strong> A casa ${descricao} foi cadastrada com sucesso!!!
			</div>
		</c:if>
		
		<c:if test="${not empty listaCasas}">
		
			<h4>Listagem de casas (${listaCasas.size()}):</h4>
			<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>#</th>
			        <th>Descricao</th>
			        <td>Numero</td>
			        <td>Andares</td>
                    <th>Area</th>
                    <th>valor</th>
                    <th>Situacao</th>
			        <th></th>
			      </tr>
			    </thead>
			    <tbody>
			    	<c:forEach var="c" items="${listaCasas}">
				      <tr>
				      	<td>${c.id}</td>
                        <td>${c.descricao}</td>
                        <td>${c.numero}</td>
                        <td>${c.andares}</td>
                        <td>${c.areaTotal}</td>
                        <td>${c.valorPropriedade}</td>
                        <td>${c.situacao}</td>
				        <td><a href="/casa/${c.id}/excluir">Excluir</a></td>
				      </tr>
			      </c:forEach>
			    </tbody>
		  	</table>
	  	</c:if>
	  			
	  	<c:if test="${empty listaCasas}">
	  		<h4>Nao existem casas cadastradas!</h4>
	  	</c:if>
	</div>
</body>
</html>