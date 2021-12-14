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

		<form action="/apartamento/incluir" method="post">
		    <div class="form-group">
            	<label>Descricao:</label>
            	<input value="Cobertura ampla a uma quadra da praia" type="text" class="form-control" placeholder="Informe uma breve descricao da propriedade" name="descricao">
            </div>
            <div class="form-group">
            	<label>Valor:</label>
            	<input value="2500000.00" type="text" class="form-control" placeholder="Informe o numero" name="valorPropriedade">
            </div>

            <div class="form-group">
            	<label>Area total:</label>
            	<input value="220" type="text" class="form-control" placeholder="Informe a area total da propriedade" name="areaTotal">
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
            	<input value="35" type="text" class="form-control" placeholder="Informe o numero" name="numero">
            </div>
		    <div class="form-group">
		      <label>Andar:</label>
		      <input value="12" type="text" class="form-control" placeholder="Informe o andar do apartamento" name="andar">
		    </div>
		
			<div class="form-group">
		      <label>unidade:</label>
		      <input value="1" type="text" class="form-control" placeholder="Informe o numero da unidade" name="unidade">
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
		      <label>Quantidade de quartos:</label>
		      <input value="3" type="text" class="form-control" placeholder="Informe o numero de quartos" name="quartos">
		    </div>

		    <div class="form-group">
		      <label>Vagas na garagem:</label>
		      <input value="2" type="text" class="form-control" placeholder="Informe a quantidade de vagas" name="vagasGaragem">
		    </div>

		    <div class="form-group">
		      <label>Ano construcao:</label>
		      <input value="1990" type="text" class="form-control" placeholder="Informe o ano de construcao" name="anoConstrucao">
		    </div>

            <div class="form-group">
              <label>Tipo de Apartamento:</label>
              <select class="form-control" name="tipoResidencia">
                <option value="PADRAO">Padrao</option>
                <option value="KITNET">Kitnet</option>
                <option value="LOFT">Loft</option>
                <option value="STUDIO">Studio</option>
                <option value="DUPLEX">Duplex</option>
                <option value="TRIPLEX">Triplex</option>
                <option value="COBERTURA" selected >Cobertura</option>
                <option value="FLAT">Flat</option>
              </select>
            </div>


			<button class="btn btn-primary" type="submit">Cadastrar</button>
		</form>
	</div>
</body>
</html>