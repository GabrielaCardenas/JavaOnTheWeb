<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="TableroStyle.css">
	<title>Tablero de Damas</title>
	
</head>
<body>
	<form action="Tablero.jsp">
		<h1>Ingrese cantidad de cuadrados para el ancho del tablero</h1>
			<input type="text" name="Ancho">
		<h1>Ingrese cantidad de cuadrados para el alto del tablero</h1>
			<input type="text" name="Alto">
		<input type="submit" value="Enviar">
	</form>
	
	<!-- Obteniendo datos ingresados por usuario -->
    <% String ancho = request.getParameter("Ancho"); %>
    <% String alto = request.getParameter("Alto"); %>
    
    <!-- Mostramos el valor que obtuvimos -->
    <% if (ancho == "" && alto == "" || ancho == "" && alto != "" || ancho != "" && alto == "") { %>
    	<h1 class="alert">Ingrese ambos datos por favor</h1>
    <% } %>
    
    <% if(ancho != "" && alto != "" && ancho != null && alto != null) { %>
    	<h3 class="alert">El tablero tiene: <%= ancho %> cuadrados de ancho y <%= alto %> cuadrados de alto</h3>
    
    	<!-- Cambiando variables String a Int -->
    	<% int width = Integer.parseInt(ancho); %>
    	<% int height = Integer.parseInt(alto); %>
    
    	<!-- Pintando el tablero -->
	    <% for (int i=0; i<height; i++) { %>
	    	<% for (int j=0; j<width; j++) { %>
	    		<% if (i%2==0 && j%2==0 || i%2!=0 && j%2!=0) { %>
	    			<div id="rojo">.</div>
	    		<% } %>
	    		<% if (i%2==0 && j%2!=0 || i%2!=0 && j%2==0 ) { %>
	    			<div id="negro">.</div>
	    		<% } %>
	    	<% } %>
	    	<br>
	    <% } %>
    <% } %>

</body>
</html>