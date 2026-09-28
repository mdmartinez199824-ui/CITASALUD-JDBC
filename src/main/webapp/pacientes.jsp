<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>CITASALUD - Pacientes</title>
</head>

<body>

    <h1>CITASALUD</h1>
    <h2>Gestión de Pacientes</h2>

    <%
        String mensaje = "Módulo web de pacientes funcionando correctamente.";
    %>

    <p><%= mensaje %></p>

    <h3>Paciente registrado correctamente</h3>

    <p>
        Los datos enviados desde el formulario fueron procesados
        mediante el Servlet y almacenados utilizando JDBC.
    </p>

    <a href="index.html">Registrar otro paciente</a>

</body>
</html>