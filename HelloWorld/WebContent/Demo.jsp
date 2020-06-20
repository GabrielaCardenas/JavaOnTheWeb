<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Demo JSP</title>
</head>
<body>

<!-- Esta es la declaraci�n de las etiquetas para los m�todos -->
    <%! 
    public int add(int a, int b) {
        return a + b;
    }
    %>
    
    <!-- Esta es una etiqueta para cualquier c�digo Java -->
    <% 
    int i = 2;
    int j = 4;
    %>
    
    <!-- Acceso directo para generar lo que devuelve nuestro m�todo al ser llamado %> -->
    <h3><%= add(i, j) %></h3>
    
    <!-- Los bucles for tambi�n funcionan! -->
    <% for(int index = 0; index < 5; index++) { %>
        <h1><%= index %></h1>
    <% } %>
    
    <!-- Aqu� tenemos que importar la clase Date. Debes colocar la sentencia import en la primera l�nea de la etiqueta de su JSP. Usar el atributo import. -->
    <p>La fecha es: <%= new Date() %></p>
    
</body>
</html>