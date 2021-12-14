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
		<form action="/comercio/incluir" method="post">
		    <div class="form-group">
            	<label>Descricao:</label>
            	<input value="Lojão amplo com dois andares" type="text" class="form-control" placeholder="Informe uma breve descricao da propriedade" name="descricao">
            </div>
            <div class="form-group">
            	<label>Valor:</label>
            	<input value="2785000.00" type="text" class="form-control" placeholder="Informe o numero" name="valorPropriedade">
            </div>

            <div class="form-group">
            	<label>Area total:</label>
            	<input value="250" type="text" class="form-control" placeholder="Informe a area total da propriedade" name="areaTotal">
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
            	<input value="1579" type="text" class="form-control" placeholder="Informe o numero" name="numero">
            </div>
		    <div class="form-group">
		      <label>Andar:</label>
		      <input value="2" type="text" class="form-control" placeholder="Informe a quantidade de andares ou o piso" name="andar">
		    </div>

			<div class="form-group">
		      <label>unidade:</label>
		      <input value="202" type="text" class="form-control" placeholder="Informe o numero da unidade" name="unidade">
		    </div>

			<div class="form-group">
		      <label>Valor do condominio:</label>
		      <input value="1000" type="text" class="form-control" placeholder="Informe o valor do condominio" name="valorCondominio">
		    </div>

			<div class="form-group">
		      <label>Nome do edificio:</label>
		      <input value="Bronx" type="text" class="form-control" placeholder="Informe o nome do edificio" name="nomeEdificio">
		    </div>

		    <div class="form-group">
		      <label>Vagas na garagem:</label>
		      <input value="3" type="text" class="form-control" placeholder="Informe a quantidade de vagas" name="vagasGaragem">
		    </div>

		    <div class="form-group">
		      <label>Ano construcao:</label>
		      <input value="1975" type="text" class="form-control" placeholder="Informe o ano de construcao" name="anoConstrucao">
		    </div>

            <div class="form-group">
              <label>Tipo de comercio:</label>
              <select class="form-control" name="tipoComercio">
                <option value="SALA_COMERCIAL">Sala Comercial</option>
                <option value="LOJA" selected >Loja</option>
                <option value="CASA_COMERCIAL">Casa Comercial</option>
                <option value="ANDAR">Andar</option>
                <option value="PREDIO_INTEIRO">Predio inteiro</option>
                <option value="GALPAO">Loja</option>
                <option value="GARAGEM">Garagem</option>
              </select>
            </div>


			<button class="btn btn-primary" type="submit">Cadastrar</button>
		</form>
	</div>
</body>
</html>