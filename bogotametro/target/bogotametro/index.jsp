<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login - Bogotá Metro</title>
</head>
<body>
    <h2>Iniciar Sesión</h2>

    <!-- Mensaje de error si el login falla -->
    <% if(request.getAttribute("mensajeError") != null) { %>
    <p style="color:red;"><%= request.getAttribute("mensajeError") %></p>
    <% } %>

    <form action="inicio" method="post">
        <!-- Le dice al controlador que es login (case 5) -->
        <input type="hidden" name="decision" value="5">

        <!-- Campos que el controlador espera -->
        <input type="hidden" name="textpas_nom_pasajero" value="">
        <input type="hidden" name="textpas_telefono" value="">
        <input type="hidden" name="textpas_correo" value="">
        <input type="hidden" name="pas_id_pasajero" value="0">
        <input type="hidden" name="pas_status_pasajero" value="false">

        <label>Tipo de documento:</label><br>
        <input type="text" name="textpas_tipo_documento"><br><br>

        <label>Número de documento:</label><br>
        <input type="text" name="textpas_nro_documento"><br><br>

        <label>Contraseña:</label><br>
        <input type="password" name="textpas_contrasena_encriptada"><br><br>

        <button type="submit">Ingresar</button>
    </form>
</body>
</html>