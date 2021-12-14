<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/app">AppVendas</a>
    </div>

    <ul class="nav navbar-nav">
      <li class="active"><a href="/">Home</a></li>

      <c:if test="${not empty user}">
        <li><a href="/usuarios">Usuario</a></li>
        <li><a href="/compradores">Compradores</a></li>
        <li><a href="/apartamentos">Apartamentos</a></li>
        <li><a href="/casas">Casas</a></li>
        <li><a href="/comercios">Comercios</a></li>
        <li><a href="/propriedades">Propriedades</a></li>
        <li><a href="/vendas">Vendas</a></li>
      </c:if>
    </ul>

    <ul class="nav navbar-nav navbar-right">
      <c:if test="${empty user}">
        <li>
          <a href="/usuario"
            ><span class="glyphicon glyphicon-user"></span> Sign Up</a
          >
        </li>
      </c:if>

      <c:if test="${empty user}">
        <li>
          <a href="/login"
            ><span class="glyphicon glyphicon-log-in"></span> Login</a
          >
        </li>
      </c:if>

      <c:if test="${not empty user}">
        <li>
          <a href="/logout"
            ><span class="glyphicon glyphicon-log-out"></span> Logout,
            ${user.nome}</a
          >
        </li>
      </c:if>
    </ul>
  </div>
</nav>
