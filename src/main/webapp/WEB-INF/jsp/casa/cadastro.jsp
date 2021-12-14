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

	<div class="container">	
		<form action="/casa/incluir" method="post">
		    <div class="form-group">
            	<label>Descricao:</label>
            	<input value="Casa conjugada" type="text" class="form-control" placeholder="Informe uma breve descricao da propriedade" name="descricao">
            </div>
            <div class="form-group">
            	<label>Valor:</label>
            	<input value="150000.00" type="text" class="form-control" placeholder="Informe o numero" name="valorPropriedade">
            </div>

            <div class="form-group">
            	<label>Area total:</label>
            	<input value="25" type="text" class="form-control" placeholder="Informe a area total da propriedade" name="areaTotal">
            </div>

		    <div class="form-group">
              <label>Situacao:</label>
              <select class="form-control" name="situacao">
                <option value="VENDA" selected >Venda</option>
                <option value="VENDIDO">Vendido</option>
              </select>
            </div>

            <c:import url="/WEB-INF/jsp/endereco.jsp"/>

		    <div class="form-group">
            	<label>Numero:</label>
            	<input value="150" type="text" class="form-control" placeholder="Informe o numero" name="numero">
            </div>

            <div class="form-group">
            	<label>Andares:</label>
            	<input value="1" type="text" class="form-control" placeholder="Informe o numero" name="andares">
            </div>

            <div class="form-group">
            	<label>Quartos:</label>
            	<input value="1" type="text" class="form-control" placeholder="Informe o numero" name="quartos">
            </div>

		    <div class="form-group">
		      <label>Vagas na garagem:</label>
		      <input value="" type="text" class="form-control" placeholder="Informe a quantidade de vagas" name="vagasGaragem">
		    </div>

		    <div class="form-group">
		      <label>Ano construcao:</label>
		      <input value="1960" type="text" class="form-control" placeholder="Informe o ano de construcao" name="anoConstrucao">
		    </div>

            <div class="form-group">
              <label>Tipo de casa:</label>
              <select class="form-control" name="tipoResidencia">
                              <option value="PADRAO">Padrao</option>
                              <option value="KITNET" selected>Kitnet</option>
                              <option value="FAZENDA">Fazenda</option>
                              <option value="STUDIO">Studio</option>
                              <option value="DUPLEX">Duplex</option>
                              <option value="TRIPLEX">Triplex</option>
                              <option value="LOTE">Lote</option>
                            </select>
            </div>
			<button class="btn btn-primary" type="submit">Cadastrar</button>
		</form>
	</div>
</body>
</html>