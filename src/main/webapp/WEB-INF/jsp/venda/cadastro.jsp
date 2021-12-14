<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	
	<c:set var="botao" value=""/>

	<div class="container">	
		<form action="/venda/incluir" method="post">
			<div class="form-group">
		      <label>Descricao:</label>
		      <input value="Minha primeira venda" type="text" class="form-control" placeholder="Entre com a descricao da venda" name="descricao">
		    </div>			

			<div class="form-group">
			<c:if test="${not empty propriedades}">
		      <label>Propriedades:</label>
		      <c:forEach var="p" items="${propriedades}">
				    <div class="form-check-inline">
				        <label class="form-check-label">
				        <input type="checkbox" name="propriedadeIds" class="form-check-input" value="${p.id}"> ${p.descricao}
				        </label>
				    </div>
			  </c:forEach>
			</c:if>  			
			<c:if test="${empty propriedades}">
		      <label>Nao existem propriedades cadastradas!!!</label>
		      <c:set var="botao" value="disabled"/>		
			</c:if>
			</div>
			
			<div class="form-group">
		    <c:if test="${not empty compradores}">
		      <label>Comprador:</label>
				<select class="form-control" name="comprador">
				  <c:forEach var="s" items="${compradores}">
					<option value="${s.id}">${s.nome}</option>
				  </c:forEach>
				</select>
			</c:if>
		    <c:if test="${empty compradores}">
		      <label>Nao existem compradores cadastrados!!!</label>
		      <c:set var="botao" value="disabled"/>
		    </c:if>
			</div>

			<button ${botao} class="btn btn-primary" type="submit">Cadastrar</button>
		</form>
	</div>
</body>
</html>