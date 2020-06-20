<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Demo JSP</title>
</head>
<body>

<!-- Esta es la declaración de las etiquetas para los métodos -->
    <%! 
    public int add(int a, int b) {
        return a + b;
    }
    %>
    
    <!-- Esta es una etiqueta para cualquier código Java -->
    <% 
    int i = 2;
    int j = 4;
    %>
    
    <!-- Acceso directo para generar lo que devuelve nuestro método al ser llamado %> -->
    <h3><%= add(i, j) %></h3>
    
    <!-- Los bucles for también funcionan! -->
    <% for(int index = 0; index < 5; index++) { %>
        <h1><%= index %></h1>
    <% } %>
    
    <!-- Aquí tenemos que importar la clase Date. Debes colocar la sentencia import en la primera línea de la etiqueta de su JSP. Usar el atributo import. -->
    <p>La fecha es: <%= new Date() %></p>
    
</body>
</html>