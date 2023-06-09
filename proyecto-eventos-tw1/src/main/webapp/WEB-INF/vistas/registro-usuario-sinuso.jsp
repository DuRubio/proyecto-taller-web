<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" >
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
<div class = "container">
    <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <form:form action="registrar-usuario" method="POST" >
            <h3 class="form-signin-heading">Nuevo Usuario</h3>
            <hr class="colorgraph"><br>

            <label for="correo">Correo:</label>
            <form:input path="correo" id="correo" class="form-control" />

            <label for="clave">Clave:</label>
            <form:input path="clave" type="password" id="clave" class="form-control"/>

            <label for="nombre">Nombre:</label>
            <form:input path="nombre" id="nombre" class="form-control" />

            <label for="apellido">Apellido:</label>
            <form:input path="apellido" id="apellido" class="form-control"/>

            <label for="localidad">Localidad:</label>
            <form:input path="localidad" id="localidad" class="form-control"/>

            <br><br><br>

            <button id="btn-registrarme" class="btn btn-lg btn-primary btn-block" Type="Submit"/>Registrarme</button>
        </form:form>

        <c:if test="${not empty mensaje}">
            <h4><span>${mensaje}</span></h4>
            <br>
        </c:if>
    </div>
</div>

<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>